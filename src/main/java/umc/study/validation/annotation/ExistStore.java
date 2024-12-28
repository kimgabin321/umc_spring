package umc.study.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.study.validation.validator.RegionExistValidator;
import umc.study.validation.validator.StoreExistValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = StoreExistValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistStore {
    String message() default "해당하는 매장이 존재하지 않습니다.";  // 기본 메시지
    Class<?>[] groups() default {};  // 그룹 설정
    Class<? extends Payload>[] payload() default {};  // 페이로드 설정
}

