package umc.spring.study.web.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;

public class MissionRequestDTO {

    @Getter
    public static class CreateMissionDTO {
        @NotBlank(message = "미션 설명은 필수입니다.")
        private String missionSpec;

        @NotNull(message = "보상은 필수입니다.")
        @Min(value = 1, message = "보상은 1 이상이어야 합니다.")
        private Integer reward;

        @NotNull(message = "마감일은 필수입니다.")
        @Future(message = "마감일은 미래여야 합니다.")
        private LocalDate deadline;
    }
}
