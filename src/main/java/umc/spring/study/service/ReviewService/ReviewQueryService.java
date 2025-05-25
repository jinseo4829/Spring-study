package umc.spring.study.service.ReviewService;

import org.springframework.data.domain.Pageable;
import umc.spring.study.web.dto.MyReviewListDTO;

public interface ReviewQueryService {

    MyReviewListDTO getMyReviews(Long memberId, Pageable pageable);
}
