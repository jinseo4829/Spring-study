package umc.spring.study.web.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import umc.spring.study.validation.annotation.StoreExists;

@Getter
@Setter
public class ReviewRequestDTO {

    @StoreExists
    private Long storeId;

    @NotBlank
    private String body;

    @NotNull
    @Min(0)
    @Max(5)
    private Float score;
}

