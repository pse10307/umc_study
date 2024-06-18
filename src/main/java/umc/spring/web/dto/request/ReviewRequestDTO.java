package umc.spring.web.dto.request;

import lombok.Getter;
import umc.spring.validation.annotation.ExistStore;

public class ReviewRequestDTO {

    @Getter
    public static class ReviewDTO{
        String body;
        float score;
    }
}
