package umc.spring.study.service.MissionService;

import lombok.RequiredArgsConstructor;
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
import umc.spring.study.web.dto.ChallengeMissionRequest;
import umc.spring.study.web.dto.MissionRequestDTO;

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
    public void challengeMission(ChallengeMissionRequest request) {
        Member member = memberRepository.findById(DEFAULT_MEMBER_ID)
                .orElseThrow(() -> new RuntimeException("하드코딩된 회원 없음")); // 실제 운영 시엔 적절한 예외 처리 필요

        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow(() -> new RuntimeException("미션 없음"));

        MemberMission memberMission = MemberMissionConverter.toMemberMission(member, mission);
        memberMissionRepository.save(memberMission);
    }
}
