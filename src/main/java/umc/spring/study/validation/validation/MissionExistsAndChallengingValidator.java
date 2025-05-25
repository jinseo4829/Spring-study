package umc.spring.study.validation.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.study.domain.enums.MissionStatus;
import umc.spring.study.repository.MemberMissionRepository.MemberMissionRepository;
import umc.spring.study.validation.annotation.MissionExistsAndChallenging;

@Component
@RequiredArgsConstructor
public class MissionExistsAndChallengingValidator implements ConstraintValidator<MissionExistsAndChallenging, Long> {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {
        return memberMissionRepository.findByMemberIdAndMissionId(1L, missionId)
                .map(m -> m.getStatus() == MissionStatus.CHALLENGING)
                .orElse(false);
    }
}
