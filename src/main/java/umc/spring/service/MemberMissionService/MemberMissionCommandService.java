package umc.spring.service.MemberMissionService;

import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.request.MemberMissionRequestDTO;

public interface MemberMissionCommandService {
    MemberMission createMemberMission(Long memberId, Long missionId, MemberMissionRequestDTO.MemberMissionDTO request);
    boolean memberMissionExist(Long missionId);
}
