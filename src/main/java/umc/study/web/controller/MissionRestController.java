package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MemberConverter;
import umc.study.converter.MissionConverter;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.mapping.MemberMission;
import umc.study.service.MemberMissionService.MemberMissionCommandService;
import umc.study.service.MemberService.MemberCommandService;
import umc.study.service.MissionService.MissionCommandService;
import umc.study.validation.annotation.ExistMember;
import umc.study.web.dto.MemberRequestDTO;
import umc.study.web.dto.MemberResponseDTO;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;
import umc.study.validation.annotation.ExistMission;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {
    private final MissionCommandService missionCommandService;

    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("/")
    public ApiResponse<MissionResponseDTO.ChallengeMissionResultDto> challenge(@RequestBody @Valid MissionRequestDTO.ChallengeMissionDto request,
                                                                               @ExistMember @RequestParam(name = "memberId") Long memberId) {
        MemberMission memberMission = memberMissionCommandService.challengeMission(request, memberId);
        return ApiResponse.onSuccess(MissionConverter.toMemberMissionResultDTO(memberMission));
    }
}