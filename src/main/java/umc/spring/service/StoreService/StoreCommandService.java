package umc.spring.service.StoreService;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Store;
import umc.spring.web.dto.request.StoreRequestDTO;

public interface StoreCommandService {
    Store createStore(Long regionId,  StoreRequestDTO.storeDTO request);
}
