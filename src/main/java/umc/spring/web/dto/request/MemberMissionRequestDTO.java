package umc.spring.web.dto.request;

import lombok.Getter;
import umc.spring.domain.enums.MissionStatus;

public class MemberMissionRequestDTO {

    @Getter
    public static class MemberMissionDTO {
        MissionStatus missionStatus;
    }
}
