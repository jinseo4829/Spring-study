package umc.spring.study.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.study.converter.MemberMissionConverter;
import umc.spring.study.domain.enums.MissionStatus;
import umc.spring.study.domain.mapping.MemberMission;
import umc.spring.study.repository.MemberMissionRepository.MemberMissionRepository;
import umc.spring.study.web.dto.MemberMissionListResponse;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public MemberMissionListResponse getProgressingMissions(int page) {
        PageRequest pageRequest = PageRequest.of(page, 10);
        Slice<MemberMission> result = memberMissionRepository.findByMemberIdAndStatus(1L, MissionStatus.CHALLENGING, pageRequest);
        return MemberMissionConverter.toMissionListDTO(result);
    }
}
