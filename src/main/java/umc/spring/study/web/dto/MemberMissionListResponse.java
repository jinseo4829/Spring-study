package umc.spring.study.web.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class MemberMissionListResponse {
    private List<MissionPreviewDTO> missionList;
    private boolean hasNext;

    @Getter
    @Builder
    public static class MissionPreviewDTO {
        private Long missionId;
        private String missionSpec;
        private String storeName;
        private Integer reward;
    }
}
