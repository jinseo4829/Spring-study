package umc.spring.study.web.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class MissionListDTO {
    private List<MissionPreviewDTO> missionList;
    private int totalPages;
    private long totalElements;
}
