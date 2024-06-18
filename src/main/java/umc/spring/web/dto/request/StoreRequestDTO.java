package umc.spring.web.dto.request;

import lombok.Getter;

public class StoreRequestDTO {
    
    @Getter
    public static class storeDTO{
        String name;
        String address;
        Float score;
    }
}
