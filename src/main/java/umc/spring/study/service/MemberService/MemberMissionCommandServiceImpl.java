package umc.spring.study.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.study.apiPayload.code.status.ErrorStatus;
import umc.spring.study.apiPayload.exception.handler.MemberMissionHandler;
import umc.spring.study.domain.enums.MissionStatus;
import umc.spring.study.domain.mapping.MemberMission;
import umc.spring.study.repository.MemberMissionRepository.MemberMissionRepository;

@Service
@RequiredArgsConstructor
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    @Transactional
    public void completeMission(Long missionId) {
        MemberMission memberMission = memberMissionRepository
                .findByMemberIdAndMissionId(1L, missionId)
                .orElseThrow(() -> new MemberMissionHandler(ErrorStatus.MEMBER_MISSION_NOT_FOUND));

        if (memberMission.getStatus() == MissionStatus.COMPLETE) {
            throw new MemberMissionHandler(ErrorStatus.MEMBER_MISSION_ALREADY_COMPLETED);
        }

        memberMission.setStatus(MissionStatus.COMPLETE);
    }
}
