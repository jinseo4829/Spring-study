package umc.spring.study.converter;

import org.springframework.data.domain.Slice;
import umc.spring.study.domain.Member;
import umc.spring.study.domain.Mission;
import umc.spring.study.domain.mapping.MemberMission;
import umc.spring.study.web.dto.MemberMissionListResponse;
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

    public static MemberMissionListResponse toMissionListDTO(Slice<MemberMission> slice) {
        return MemberMissionListResponse.builder()
                .missionList(slice.getContent().stream()
                        .map(m -> MemberMissionListResponse.MissionPreviewDTO.builder()
                                .missionId(m.getMission().getId())
                                .missionSpec(m.getMission().getMissionSpec())
                                .storeName(m.getMission().getStore().getName())
                                .reward(m.getMission().getReward())
                                .build())
                        .toList())
                .hasNext(slice.hasNext())
                .build();
    }
}
