package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.MemberMissionService.MemberMissionQueryService;
import umc.spring.validation.annotation.CheckPage;
import umc.spring.validation.annotation.ExistMember;
import umc.spring.validation.validator.PageValidator;
import umc.spring.web.dto.response.MemberMissionResponseDTO;

@RestController
@RequiredArgsConstructor
public class MemberMissionController {

    private final MemberMissionQueryService memberMissionQueryService;

    @GetMapping("/members/{memberId}/missions")
    @Operation(summary = "특정 사용자가 진행 중인 미션 목록 조회 API",description = "특정 사용자가 진행 중인 미션 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "사용자의 아이디, path variable 입니다!")
    })
    public ApiResponse<MemberMissionResponseDTO.MissionPreViewListDTO> getMissions(
            @PathVariable(name = "memberId") @ExistMember Long memberId,
            @RequestParam(name = "page") @CheckPage Integer page) {

        int newpage = PageValidator.toZeroBasedPage(page);

        Page<Mission> missionList = memberMissionQueryService.getMissionListByMemberAndStatus(memberId, MissionStatus.CHALLENGING, newpage);
        return ApiResponse.onSuccess(MemberMissionConverter.missionPreViewListDTO(missionList));
    }
}

