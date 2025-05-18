package umc.spring.study.converter;

import umc.spring.study.domain.Member;
import umc.spring.study.domain.Review;
import umc.spring.study.domain.Store;
import umc.spring.study.web.dto.ReviewRequestDTO;

public class ReviewConverter {
    public static Review toReview(ReviewRequestDTO dto, Member member, Store store) {
        return Review.builder()
                .body(dto.getBody())
                .score(dto.getScore())
                .member(member)
                .store(store)
                .build();
    }
}
