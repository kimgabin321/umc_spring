package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.apiPayload.exception.handler.StoreHandler;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.domain.Member;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class MissionConverter {

    public static MissionResponseDTO toMissionResponseDTO(Mission mission) {
        return MissionResponseDTO.builder()
                .missionId(mission.getId())
                .reward(mission.getReward())
                .deadline(mission.getDeadline())
                .missionSpec(mission.getMissionSpec())
                .build();
    }

    public static Mission toMission(MissionRequestDTO request, StoreRepository storeRepository) {
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        return Mission.builder()
                .reward(request.getReward())
                .deadline(request.getDeadline())
                .missionSpec(request.getMissionSpec())
                .store(store)
                .build();
    }

    public static MissionResponseDTO.ChallengeMissionResultDto toMemberMissionResultDTO (MemberMission memberMission){
        return MissionResponseDTO.ChallengeMissionResultDto.builder()
                .memberMissionId(memberMission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
    public static MemberMission toMemberMissionDTO (MissionRequestDTO.ChallengeMissionDto request, Member member, Mission mission){
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.CHALLENGING)
                .build();
    }

    public static MissionResponseDTO.MissionPreviewDTO toMissionPreviewDTO (Mission mission){
        return MissionResponseDTO.MissionPreviewDTO.builder()
                .missionId(mission.getId())
                .missionSpec(mission.getMissionSpec())
                .reward(mission.getReward())
                .createdAt(mission.getCreatedAt())
                .build();
    }
    public static MissionResponseDTO.MissionPreviewListDTO toMissionPreviewListDTO (Page<Mission> missionList){
        List<MissionResponseDTO.MissionPreviewDTO> missionPreviewDTOList = missionList.stream()
                .map(MissionConverter::toMissionPreviewDTO).collect(Collectors.toList());
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
