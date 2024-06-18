package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.MemberMissionService.MemberMissionCommandService;
import umc.spring.validation.annotation.ExistMemberMission;
import umc.spring.web.dto.request.MemberMissionRequestDTO;
import umc.spring.web.dto.response.MemberMissionResponseDTO;

@RestController
@RequiredArgsConstructor
public class MemberMissionController {

    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("members/{memberId}/missions/{missionId}/memberMissions")
    public ApiResponse<MemberMissionResponseDTO.MemberMissionResultDTO> createMemberMission(@PathVariable("memberId") Long memberId, @ExistMemberMission @PathVariable("missionId") Long missionId, @RequestBody MemberMissionRequestDTO.MemberMissionDTO request) {
        MemberMission memberMission = memberMissionCommandService.createMemberMission(memberId, missionId, request);
        return ApiResponse.onSuccess(MemberMissionConverter.toMemberMissionResultDTO(memberMission));
    }
}
