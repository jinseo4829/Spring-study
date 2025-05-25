package umc.spring.study.web.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class MyReviewListDTO {
    private List<ReviewInfoDTO> reviews;
    private int currentPage;
    private int totalPages;
}
