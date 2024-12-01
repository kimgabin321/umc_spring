package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class ReviewResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class WriteReviewDTO {
        private Long reviewId;
        private String title;
        private String body;
        private Float score;
        private String memberName;
        private String storeName;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
    }
}
