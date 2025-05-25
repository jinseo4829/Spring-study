package umc.spring.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.study.apiPayload.ApiResponse;
import umc.spring.study.converter.MemberConverter;
import umc.spring.study.domain.Member;
import umc.spring.study.service.MemberService.MemberCommandService;
import umc.spring.study.service.MemberService.MemberMissionCommandService;
import umc.spring.study.service.MemberService.MemberMissionQueryService;
import umc.spring.study.validation.annotation.MissionExistsAndChallenging;
import umc.spring.study.validation.annotation.ValidPage;
import umc.spring.study.web.dto.MemberMissionListResponse;
import umc.spring.study.web.dto.MemberRequestDTO;
import umc.spring.study.web.dto.MemberResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;
    private final MemberMissionCommandService memberMissionCommandService;
    private final MemberMissionQueryService memberMissionQueryService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @GetMapping("/missions/progress")
    @Operation(summary = "진행 중인 미션 목록 조회", description = "로그인 없이 memberId=1 기준 진행 중인 미션 목록을 조회합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "PAGE4001", description = "페이지는 1 이상이어야 합니다.")
    })
    public ApiResponse<MemberMissionListResponse> getProgressingMissions(@ValidPage @RequestParam(name = "page") Integer page) {
        return ApiResponse.onSuccess(memberMissionQueryService.getProgressingMissions(page));
    }

    @PatchMapping("/missions/{missionId}/complete")
    @Operation(summary = "진행 중인 미션 완료 처리", description = "고정된 memberId = 1 사용")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "MISSION4002", description = "해당 미션은 이미 완료됐습니다."),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "MISSION4001", description = "진행 중인 미션이 존재하지 않습니다.")
    })
    public ApiResponse<String> completeMission(
            @PathVariable @MissionExistsAndChallenging Long missionId) {
        memberMissionCommandService.completeMission(missionId);
        return ApiResponse.onSuccess("완료 처리 성공");
    }
}
