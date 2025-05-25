package umc.spring.study.service.MemberService;

import umc.spring.study.web.dto.MemberMissionListResponse;

public interface MemberMissionQueryService {

    public MemberMissionListResponse getProgressingMissions(int page);

}
