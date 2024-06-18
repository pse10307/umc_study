package umc.spring.converter;

import umc.spring.domain.Store;
import umc.spring.web.dto.request.StoreRequestDTO;
import umc.spring.web.dto.response.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {

    public static StoreResponseDTO.StoreResultDTO toStoreResultDTO(Store store) {
        return StoreResponseDTO.StoreResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDTO.storeDTO request) {
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .score(request.getScore())
                .build();
    }
}
