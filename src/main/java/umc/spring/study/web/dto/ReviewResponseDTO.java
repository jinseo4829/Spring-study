package umc.spring.study.web.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class ReviewResponseDTO {
    private Long ReviewId;
    private String title;
    private String body;
    private Float score;
    private LocalDate Date;
}
