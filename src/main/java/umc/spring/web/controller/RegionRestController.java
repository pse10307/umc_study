package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.RegionConverter;
import umc.spring.domain.Region;
import umc.spring.service.RegionService.RegionCommandService;
import umc.spring.web.dto.request.RegionRequestDTO;
import umc.spring.web.dto.response.RegionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/regions")
public class RegionRestController {

    private final RegionCommandService regionCommandService;

    @PostMapping("/")
    public ApiResponse<RegionResponseDTO.RegionResultDTO> createRegion(@RequestBody RegionRequestDTO.RegionDTO request) {
        Region region = regionCommandService.createRegion(request);
        return ApiResponse.onSuccess(RegionConverter.toRegionResultDTO(region));
    }

}
