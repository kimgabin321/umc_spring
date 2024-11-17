package umc.study.apiPayload.code;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@Builder
public class ReasonDTO {
    private final HttpStatus httpStatus; // HTTP 상태 코드 (선택적)
    private final boolean isSuccess;    // 성공 여부
    private final String code;          // 상태 코드
    private final String message;       // 메시지
}
