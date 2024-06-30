package umc.spring.service.MemberMissionService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.response.MemberMissionResponseDTO;

import java.util.Optional;

public interface MemberMissionQueryService {
    Page<Mission> getMissionListByMemberAndStatus(Long memberId, MissionStatus status, Integer page);
}
