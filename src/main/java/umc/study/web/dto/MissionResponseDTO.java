package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MissionResponseDTO {
    private Long missionId;
    private Integer reward;
    private LocalDate deadline;
    private String missionSpec;
}
