package umc.spring.converter;

import umc.spring.domain.Region;
import umc.spring.web.dto.request.RegionRequestDTO;
import umc.spring.web.dto.response.RegionResponseDTO;

import java.time.LocalDateTime;

public class RegionConverter {

    public static RegionResponseDTO.RegionResultDTO toRegionResultDTO(Region region) {
        return RegionResponseDTO.RegionResultDTO.builder()
                .regionId(region.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Region toRegion(RegionRequestDTO.RegionDTO request) {
        return Region.builder()
                .name(request.getName())
                .build();
    }
}
