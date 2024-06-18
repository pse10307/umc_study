package umc.spring.service.StoreService;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.RegionHandler;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.repository.RegionRepository;
import umc.spring.repository.StoreRepository;
import umc.spring.web.dto.request.StoreRequestDTO;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    @Transactional
    public Store createStore(Long regionId, StoreRequestDTO.storeDTO request){
        Store newStore = StoreConverter.toStore(request);
        Region region = regionRepository.findById(regionId).orElseThrow(() -> new RegionHandler(ErrorStatus._NOT_FOUND_REGION));
        newStore.setRegion(region);
        storeRepository.save(newStore);
        return newStore;
    }
}
