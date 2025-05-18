package umc.spring.study.web.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.study.validation.annotation.MissionNotChallenged;

@Getter
public class ChallengeMissionRequest {

    @NotNull(message = "미션 ID는 필수입니다.")
    @MissionNotChallenged
    private Long missionId;
}
