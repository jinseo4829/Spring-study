package umc.spring.study.service.StoreService;

import umc.spring.study.domain.Store;
import umc.spring.study.web.dto.StoreRequestDTO;
import umc.spring.study.web.dto.StoreResponseDTO;

public interface StoreCommandService {
    StoreResponseDTO createStore(StoreRequestDTO requestDTO);
}
