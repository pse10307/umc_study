package umc.spring.web.dto.request;

import lombok.Getter;
import umc.spring.domain.enums.MissionStatus;

import java.time.LocalDate;

public class MemberMissionRequestDTO {

    @Getter
    public static class MemberMissionDTO {
        MissionStatus missionStatus;
    }

    @Getter
    public static class MissionDTO{
        Integer reward;
        LocalDate deadline;
        String missionSpec;
    }
}
