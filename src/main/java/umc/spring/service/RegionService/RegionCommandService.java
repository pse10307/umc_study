package umc.spring.service.RegionService;

import umc.spring.domain.Region;
import umc.spring.web.dto.request.RegionRequestDTO;


public interface RegionCommandService {
    Region createRegion(RegionRequestDTO.RegionDTO request);
}
