package umc.spring.study.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.study.converter.ReviewConverter;
import umc.spring.study.domain.Review;
import umc.spring.study.repository.ReviewRepository.ReviewRepository;
import umc.spring.study.web.dto.MyReviewListDTO;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ReviewRepository reviewRepository;

    public MyReviewListDTO getMyReviews(Long memberId, Pageable pageable) {
        Page<Review> page = reviewRepository.findByMemberId(memberId, pageable);
        return ReviewConverter.toMyReviewListDTO(page);
    }
}
