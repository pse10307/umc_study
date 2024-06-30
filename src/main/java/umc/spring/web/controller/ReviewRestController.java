package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberConverter;
import umc.spring.converter.ReviewConverter;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Review;
import umc.spring.service.MemberService.MemberQueryService;
import umc.spring.validation.annotation.CheckPage;
import umc.spring.validation.annotation.ExistStore;
import umc.spring.validation.validator.PageValidator;
import umc.spring.web.dto.request.ReviewRequestDTO;
import umc.spring.web.dto.response.MemberResponseDTO;
import umc.spring.web.dto.response.ReviewResponseDTO;
import umc.spring.service.ReviewService.ReviewCommandService;
import umc.spring.web.dto.response.StoreResponseDTO;

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

