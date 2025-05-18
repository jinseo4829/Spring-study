package umc.spring.study.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.study.validation.validation.MissionNotChallengedValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MissionNotChallengedValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface MissionNotChallenged {
    String message() default "이미 도전 중인 미션입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}