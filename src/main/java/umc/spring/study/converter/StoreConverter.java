package umc.spring.study.converter;

import umc.spring.study.domain.Region;
import umc.spring.study.domain.Store;
import umc.spring.study.web.dto.StoreRequestDTO;
import umc.spring.study.web.dto.StoreResponseDTO;

public class StoreConverter {

    public static Store toStore(StoreRequestDTO dto, Region region) {
        return Store.builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .score(dto.getScore())
                .region(region)
                .build();
    }

    public static StoreResponseDTO toStoreResponseDTO(Store store){
        return StoreResponseDTO.builder()
                .storeId(store.getId())
                .storeName(store.getName())
                .storeAddress(store.getAddress())
                .build();
    }
}
