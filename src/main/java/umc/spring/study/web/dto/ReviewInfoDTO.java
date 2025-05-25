package umc.spring.study.web.dto;


import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ReviewInfoDTO {
    private String body;
    private Float score;
    private LocalDateTime createdAt;
}
