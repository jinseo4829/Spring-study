package umc.spring.study.converter;

import umc.spring.study.domain.Member;
import umc.spring.study.domain.Mission;
import umc.spring.study.domain.Review;
import umc.spring.study.domain.Store;
import umc.spring.study.web.dto.ReviewRequestDTO;
import umc.spring.study.web.dto.ReviewResponseDTO;

public class ReviewConverter {
    public static Review toReview(ReviewRequestDTO dto, Member member, Store store) {
        return Review.builder()
                .body(dto.getBody())
                .score(dto.getScore())
                .member(member)
                .store(store)
                .build();
    }

    public static ReviewResponseDTO toReviewResponseDTO(Review review) {
        return ReviewResponseDTO.builder()
                .ReviewId(review.getId())
                .body(review.getBody())
                .score(review.getScore())
                //.Date(review.getDate())
                .build();
    }
}
