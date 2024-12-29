package umc.study.service.MemberMissionService;

import org.springframework.data.domain.Page;
import umc.study.domain.Mission;

public interface MemberMissionQueryService {
    Page<Mission> getChallengingMissionList(Long memberId, Integer page);
}