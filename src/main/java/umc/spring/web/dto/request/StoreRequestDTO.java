package umc.spring.web.dto.request;

import lombok.Getter;

import java.time.LocalDate;

public class StoreRequestDTO {
    
    @Getter
    public static class storeDTO{
        String name;
        String address;
        Float score;
    }

    @Getter
    public static class ReviewDTO{
        String title;
        Float Score;
        String body;
    }

    @Getter
    public static class MissionDTO{
        Integer reward;
        LocalDate deadline;
        String missionSpec;
    }
}
