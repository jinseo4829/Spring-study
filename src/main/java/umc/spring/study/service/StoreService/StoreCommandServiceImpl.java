package umc.spring.study.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.study.apiPayload.code.status.ErrorStatus;
import umc.spring.study.apiPayload.exception.handler.StoreHandler;
import umc.spring.study.converter.StoreConverter;
import umc.spring.study.domain.Region;
import umc.spring.study.domain.Store;
import umc.spring.study.repository.RegionRepository.RegionRepository;
import umc.spring.study.repository.StoreRepository.StoreRepository;
import umc.spring.study.web.dto.StoreRequestDTO;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    public Store createStore(StoreRequestDTO requestDTO) {
        Region region = regionRepository.findById(requestDTO.getRegionId())
                .orElseThrow(() -> new StoreHandler(ErrorStatus.REGION_NOT_FOUND));

        Store store = StoreConverter.toStore(requestDTO, region);
        return storeRepository.save(store);
    }
}
