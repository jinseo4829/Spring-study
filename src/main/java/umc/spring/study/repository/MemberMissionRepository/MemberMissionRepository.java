package umc.spring.study.repository.MemberMissionRepository;


import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.study.domain.enums.MissionStatus;
import umc.spring.study.domain.mapping.MemberMission;

import java.util.Optional;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    boolean existsByMember_IdAndMission_Id(Long memberId, Long missionId);
    Slice<MemberMission> findByMemberIdAndStatus(Long memberId, MissionStatus status, Pageable pageable);
    Optional<MemberMission> findByMemberIdAndMissionId(Long memberId, Long missionId);
}