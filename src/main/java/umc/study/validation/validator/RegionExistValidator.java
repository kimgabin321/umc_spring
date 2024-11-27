package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.repository.RegionRepository;
import umc.study.validation.annotation.ExistRegion;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RegionExistValidator implements ConstraintValidator<ExistRegion, List<Long>> {

    private final RegionRepository regionRepository;

    @Override
    public void initialize(ExistRegion constraintAnnotation) {
        // 초기화가 필요하면 사용할 수 있습니다.
    }

    @Override
    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
        // 주어진 지역 ID들이 모두 데이터베이스에 존재하는지 확인
        boolean isValid = values.stream()
                .allMatch(value -> regionRepository.existsById(value));

        if (!isValid) {
            // 유효하지 않으면 기본 오류 메시지 대신 커스텀 메시지 설정
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.REGION_NOT_FOUND.toString())
                    .addConstraintViolation();
        }

        return isValid;
    }
}
