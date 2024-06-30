package umc.spring.converter;

import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.request.MemberMissionRequestDTO;
import umc.spring.web.dto.response.MemberMissionResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class MemberMissionConverter {

    public static MemberMission toMemberMission(MemberMissionRequestDTO.MemberMissionDTO request) {
        return MemberMission.builder()
                .status(request.getMissionStatus())
                .build();
    }

    public static MemberMissionResponseDTO.MemberMissionResultDTO toMemberMissionResultDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.MemberMissionResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .createAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(MemberMissionRequestDTO.MissionDTO request) {
        return Mission.builder()
                .reward(request.getReward())
                .missionSpec(request.getMissionSpec())
                .deadline(request.getDeadline())
                .build();
    }

    public static MemberMissionResponseDTO.CreateMissionResultDTO createMissionRequstDTO(Mission mission){
        return MemberMissionResponseDTO.CreateMissionResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static MemberMissionResponseDTO.MissionPreViewDTO missionPreViewDTO(Mission mission){
        return MemberMissionResponseDTO.MissionPreViewDTO.builder()
                .missionId(mission.getId())
                .createAt(LocalDateTime.now())
                .ownerStoreName(mission.getStore().getName())
                .reward(mission.getReward())
                .missionSpec(mission.getMissionSpec())
                .deadline(mission.getDeadline())
                .build();
    }

    public static MemberMissionResponseDTO.MissionPreViewListDTO missionPreViewListDTO(Page<Mission> missionList){
        List<MemberMissionResponseDTO.MissionPreViewDTO> missionPreViewDTOList = missionList.stream()
                .map(MemberMissionConverter::missionPreViewDTO).collect(Collectors.toList());

        return MemberMissionResponseDTO.MissionPreViewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPages(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreViewDTOList.size())
                .missionList(missionPreViewDTOList)
                .build();
    }
}
