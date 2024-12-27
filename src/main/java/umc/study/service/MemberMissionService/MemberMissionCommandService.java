package umc.study.service.MemberMissionService;

import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.MissionRequestDTO;
import jakarta.transaction.Transactional;

public interface MemberMissionCommandService {
    @Transactional
    MemberMission challengeMission(MissionRequestDTO.ChallengeMissionDto request, Long memberId);
}
