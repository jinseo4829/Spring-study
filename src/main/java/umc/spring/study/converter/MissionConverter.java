package umc.spring.study.converter;

import umc.spring.study.domain.Mission;
import umc.spring.study.domain.Store;
import umc.spring.study.web.dto.MissionRequestDTO;

public class MissionConverter {
    public static Mission toMission(MissionRequestDTO.CreateMissionDTO dto, Store store) {
        return Mission.builder()
                .missionSpec(dto.getMissionSpec())
                .reward(dto.getReward())
                .deadline(dto.getDeadline())
                .store(store)
                .build();
    }
}
