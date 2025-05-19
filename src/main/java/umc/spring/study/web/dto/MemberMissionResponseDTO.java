package umc.spring.study.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberMissionResponseDTO {
    private Long memberMissionId;
    private Long memberId;
    private Long missionId;
    private String status;
}
