package umc.spring.converter;

import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.request.MemberMissionRequestDTO;
import umc.spring.web.dto.response.MemberMissionResponseDTO;

import java.time.LocalDateTime;

public class MemberMissionConverter {
    public static MemberMissionResponseDTO.MemberMissionResultDTO toMemberMissionResultDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.MemberMissionResultDTO.builder()
                .MemberMissionId(memberMission.getId())
                .createAt(LocalDateTime.now())
                .build();
    }

    public static MemberMission toMemberMission(MemberMissionRequestDTO.MemberMissionDTO request) {
        return MemberMission.builder()
                .status(request.getMissionStatus())
                .build();
    }
}
