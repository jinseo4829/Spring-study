package umc.spring.study.converter;

import umc.spring.study.domain.Member;
import umc.spring.study.domain.Mission;
import umc.spring.study.domain.mapping.MemberMission;
import umc.spring.study.web.dto.MemberMissionResponseDTO;

public class MemberMissionConverter {

    public static MemberMission toMemberMission(Member member, Mission mission) {
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .build();
    }

    public static MemberMissionResponseDTO toResponseDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.builder()
                .memberMissionId(memberMission.getId())
                .memberId(memberMission.getMember().getId())
                .missionId(memberMission.getMission().getId())
                .status(memberMission.getStatus().name())
                .build();
    }
}
