package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.validation.annotation.ExistStore;
import umc.spring.web.dto.request.ReviewRequestDTO;
import umc.spring.web.dto.response.ReviewResponseDTO;
import umc.spring.service.ReviewService.ReviewCommandService;

@RestController
@RequiredArgsConstructor
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/members/{memberId}/stores/{storeId}/reviews")
    public ApiResponse<ReviewResponseDTO.ReviewResultDTO> createReview(Long memberId, @RequestBody ReviewRequestDTO.ReviewDTO request, @ExistStore @PathVariable("storeId") Long storeId) {
        Review review = reviewCommandService.createReview(memberId, storeId, request);
        return ApiResponse.onSuccess(ReviewConverter.toReviewResultDTO(review));
    }
}

