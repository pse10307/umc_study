package umc.spring.service.RegionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.converter.RegionConverter;
import umc.spring.domain.Region;
import umc.spring.repository.RegionRepository;
import umc.spring.service.MemberService.MemberCommandService;
import umc.spring.web.dto.request.RegionRequestDTO;
import umc.spring.web.dto.response.RegionResponseDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RegionCommandServiceImpl implements RegionCommandService {

    private final RegionRepository regionRepository;

    @Override
    @Transactional
    public Region createRegion(RegionRequestDTO.RegionDTO request) {
        Region newRegion = RegionConverter.toRegion(request);
        return regionRepository.save(newRegion);
    }
}
