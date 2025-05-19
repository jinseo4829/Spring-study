package umc.spring.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.spring.study.apiPayload.ApiResponse;
import umc.spring.study.service.MissionService.MissionCommandService;
import umc.spring.study.web.dto.ChallengeMissionRequest;
import umc.spring.study.web.dto.MemberMissionResponseDTO;
import umc.spring.study.web.dto.MissionRequestDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/store/{storeId}")
    public ResponseEntity<String> createMission(@PathVariable Long storeId,
                                                @RequestBody @Valid MissionRequestDTO.CreateMissionDTO request) {
        missionCommandService.createMission(storeId, request);
        return ResponseEntity.ok("미션이 성공적으로 추가되었습니다.");
    }

    @PostMapping("/challenge")
    public ApiResponse<MemberMissionResponseDTO> challengeMission(@RequestBody @Valid ChallengeMissionRequest request) {
        return ApiResponse.onSuccess(missionCommandService.challengeMission(request));
    }
}
