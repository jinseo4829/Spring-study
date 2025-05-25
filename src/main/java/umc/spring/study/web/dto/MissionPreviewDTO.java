package umc.spring.study.web.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class MissionPreviewDTO {
    private Long missionId;
    private String missionSpec;
    private Integer reward;
    private LocalDate deadline;
}