package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.RegionConverter;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Store;
import umc.spring.service.StoreService.StoreCommandService;
import umc.spring.web.dto.request.StoreRequestDTO;
import umc.spring.web.dto.response.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    @PostMapping("/regions/{regionId}")
    public ApiResponse<StoreResponseDTO.StoreResultDTO> createStore(@PathVariable Long regionId, @RequestBody StoreRequestDTO.storeDTO request) {
        Store store = storeCommandService.createStore(regionId, request);
        return ApiResponse.onSuccess(StoreConverter.toStoreResultDTO(store));
    }
}
