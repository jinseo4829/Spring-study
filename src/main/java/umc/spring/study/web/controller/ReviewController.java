package umc.spring.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.study.service.ReviewService.ReviewCommandService;
import umc.spring.study.web.dto.ReviewRequestDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping
    public ResponseEntity<String> createReview(@RequestBody @Valid ReviewRequestDTO dto) {
        reviewCommandService.addReview(dto);
        return ResponseEntity.ok("리뷰 등록 완료");
    }
}