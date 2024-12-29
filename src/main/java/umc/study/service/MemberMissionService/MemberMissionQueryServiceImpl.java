package umc.study.service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.MemberHandler;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.enums.MissionStatus;
import umc.study.repository.MemberMissionRepository;
import umc.study.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService {
    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    @Override
    public Page<Mission> getChallengingMissionList(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId) .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Page<Mission> challengingMissionPage = memberMissionRepository.findChallengingMissionsByMember(
                member, MissionStatus.CHALLENGING, PageRequest.of(page, 10)
        );
        return challengingMissionPage;
    }
}
