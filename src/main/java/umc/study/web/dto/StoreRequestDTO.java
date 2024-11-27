package umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

public class StoreRequestDTO {

    @Getter
    public static class StoreDto {
        @NotBlank(message = "가게 이름은 필수 항목입니다.")
        private String name;

        @NotBlank(message = "주소는 필수 항목입니다.")
        @Size(min = 5, max = 100, message = "주소는 5자 이상 100자 이하로 입력해주세요.")
        private String address;

        @NotNull(message = "지역 ID는 필수 항목입니다.")
        private Long regionId;

        private Float score;
    }
}
