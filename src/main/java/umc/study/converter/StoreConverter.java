package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.Mission;
import umc.study.domain.Region;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.web.dto.MissionResponseDTO;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

//    public static StoreResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
//        return null;
//    }
//    public static StoreResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(List<Review> reviewList){
//        return null;
//    }


    public static StoreResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review) {
        return StoreResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }

    public static StoreResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList) {

        List<StoreResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(StoreConverter::reviewPreViewDTO).collect(Collectors.toList());

        return StoreResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }

    public static MissionResponseDTO.MissionPreviewDTO missionPreviewDTO(Mission mission) {
        return MissionResponseDTO.MissionPreviewDTO.builder()
                .ownerNickname(mission.getStore().getName())
                .reward(mission.getReward())
                .body(mission.getMissionSpec())
                .build();
    }

    public static MissionResponseDTO.MissionPreviewListDTO missionPreviewListDTO(Page<Mission> missionList) {
        List<MissionResponseDTO.MissionPreviewDTO> missionPreviewDTOList = missionList.stream()
                .map(StoreConverter::missionPreviewDTO).collect(Collectors.toList());
        return MissionResponseDTO.MissionPreviewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreviewDTOList.size())
                .missionList(missionPreviewDTOList)
                .build();
    }
}