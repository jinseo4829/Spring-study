package umc.spring.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.spring.study.apiPayload.ApiResponse;
import umc.spring.study.service.ReviewService.ReviewCommandService;
import umc.spring.study.service.ReviewService.ReviewQueryService;
import umc.spring.study.validation.annotation.ValidPage;
import umc.spring.study.web.dto.MyReviewListDTO;
import umc.spring.study.web.dto.ReviewRequestDTO;
import umc.spring.study.web.dto.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewCommandService reviewCommandService;
    private final ReviewQueryService reviewQueryService;

    @PostMapping
    public ApiResponse<ReviewResponseDTO> createReview(@RequestBody @Valid ReviewRequestDTO dto) {
        return ApiResponse.onSuccess(reviewCommandService.addReview(dto));
    }

    @GetMapping("/members/{memberId}")
    @Operation(summary = "내가 작성한 리뷰 목록 조회 API", description = "특정 유저가 작성한 리뷰를 페이징으로 조회합니다.")
    @Parameters({
            @Parameter(name = "memberId", description = "멤버 ID"),
            @Parameter(name = "page", description = "1부터 시작하는 페이지 번호")
    })
    public ApiResponse<MyReviewListDTO> getMyReviews(
            @PathVariable Long memberId,
            @Valid @ValidPage @RequestParam(name = "page") Integer page
    ) {
        PageRequest pageable = PageRequest.of(page - 1, 10);
        return ApiResponse.onSuccess(reviewQueryService.getMyReviews(memberId, pageable));
    }
}