package umc.spring.service.ReviewService;

import umc.spring.domain.Review;
import umc.spring.web.dto.request.ReviewRequestDTO;

public interface ReviewCommandService {
    Review createReview(Long memberId, Long storeId, ReviewRequestDTO.ReviewDTO request);
    boolean storeExist(Long storeId);
}
