package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.validation.annotation.ExistMission;

import java.time.LocalDate;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MissionRequestDTO {
    private Integer reward;
    private LocalDate deadline;
    private String missionSpec;
    private Long storeId;

    @Getter
    public static class ChallengeMissionDto{
        @ExistMission
        private Long missionId;
    }
}
