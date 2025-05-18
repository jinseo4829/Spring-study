package umc.spring.study.validation.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.study.repository.MemberMissionRepository.MemberMissionRepository;
import umc.spring.study.validation.annotation.MissionNotChallenged;

@Component
@RequiredArgsConstructor
public class MissionNotChallengedValidator implements ConstraintValidator<MissionNotChallenged, Long> {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public void initialize(MissionNotChallenged constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {
        // 여기서 고정된 memberId = 1L 로 판단합니다 (하드코딩된 유저)
        boolean isNotChallenged = !memberMissionRepository.existsByMember_IdAndMission_Id(1L, missionId);

        if (!isNotChallenged) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("이미 도전 중인 미션입니다.").addConstraintViolation();
        }

        return isNotChallenged;
    }
}
