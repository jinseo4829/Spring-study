package umc.spring.study.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.study.apiPayload.code.status.ErrorStatus;
import umc.spring.study.apiPayload.exception.handler.StoreHandler;
import umc.spring.study.converter.MemberMissionConverter;
import umc.spring.study.converter.MissionConverter;
import umc.spring.study.domain.Member;
import umc.spring.study.domain.Mission;
import umc.spring.study.domain.Store;
import umc.spring.study.domain.mapping.MemberMission;
import umc.spring.study.repository.MemberMissionRepository.MemberMissionRepository;
import umc.spring.study.repository.MemberRepository.MemberRepository;
import umc.spring.study.repository.MissionRepository.MissionRepository;
import umc.spring.study.repository.StoreRepository.StoreRepository;
import umc.spring.study.web.dto.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;

    private static final Long DEFAULT_MEMBER_ID = 1L;

    @Override
    @Transactional
    public Mission createMission(Long storeId, MissionRequestDTO.CreateMissionDTO dto) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        Mission mission = MissionConverter.toMission(dto, store);
        return missionRepository.save(mission);
    }

    @Override
    @Transactional
    public MemberMissionResponseDTO challengeMission(ChallengeMissionRequest request) {
        Member member = memberRepository.findById(DEFAULT_MEMBER_ID)
                .orElseThrow(() -> new RuntimeException("하드코딩된 회원 없음")); // 실제 운영 시엔 적절한 예외 처리 필요

        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow(() -> new RuntimeException("미션 없음"));

        MemberMission memberMission = MemberMissionConverter.toMemberMission(member, mission);
        memberMissionRepository.save(memberMission);
        return MemberMissionConverter.toResponseDTO(memberMission);
    }

    @Override
    public MissionListDTO getStoreMissionList(Long storeId, int page) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by("deadline").ascending());

        Page<Mission> missions = missionRepository.findByStoreIdAndDeadlineAfter(
                storeId, LocalDate.now(), pageable);

        List<MissionPreviewDTO> content = missions.getContent().stream()
                .map(MissionConverter::toMissionPreviewDTO)
                .collect(Collectors.toList());

        return MissionListDTO.builder()
                .missionList(content)
                .totalPages(missions.getTotalPages())
                .totalElements(missions.getTotalElements())
                .build();
    }
}
