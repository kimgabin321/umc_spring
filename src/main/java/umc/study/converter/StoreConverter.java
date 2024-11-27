package umc.study.converter;

import umc.study.domain.Region;
import umc.study.domain.Store;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {

    public static Store toStore(StoreRequestDTO.StoreDto request, Region region) {
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .score(request.getScore() != null ? request.getScore() : 0.0f)  // 기본값 설정
                .region(region)
                .build();
    }

    public static StoreResponseDTO.AddStoreResponseDTO toAddStoreResponseDTO(Store store) {
        return StoreResponseDTO.AddStoreResponseDTO.builder()
                .storeId(store.getId())
                .createdAt(store.getCreatedAt())
                .build();
    }
}