package umc.spring.study.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StoreResponseDTO {
    private Long storeId;
    private String storeName;
    private String storeAddress;
}