package umc.spring.study.web.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StoreRequestDTO {

    @NotBlank(message = "가게 이름은 필수입니다.")
    private String name;

    @NotBlank(message = "가게 주소는 필수입니다.")
    private String address;

    @NotNull(message = "평점은 필수입니다.")
    @Min(0)
    @Max(5)
    private Float score;

    @NotNull(message = "지역 ID는 필수입니다.")
    private Long regionId;
}