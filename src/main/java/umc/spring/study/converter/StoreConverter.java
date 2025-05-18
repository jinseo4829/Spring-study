package umc.spring.study.converter;

import umc.spring.study.domain.Region;
import umc.spring.study.domain.Store;
import umc.spring.study.web.dto.StoreRequestDTO;

public class StoreConverter {

    public static Store toStore(StoreRequestDTO dto, Region region) {
        return Store.builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .score(dto.getScore())
                .region(region)
                .build();
    }
}
