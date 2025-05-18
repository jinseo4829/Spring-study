package umc.spring.study.service.MissionService;


import umc.spring.study.domain.Mission;
import umc.spring.study.web.dto.ChallengeMissionRequest;
import umc.spring.study.web.dto.MissionRequestDTO;

public interface MissionCommandService {
    Mission createMission(Long storeId, MissionRequestDTO.CreateMissionDTO dto);
    void challengeMission(ChallengeMissionRequest request);
}