package umc.study.apiPayload.code;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.http.HttpStatus;

@Getter
@Builder
public class ErrorReasonDTO {

    @NonNull
    private final HttpStatus httpStatus;  // @NonNull로 null 체크

    private final boolean isSuccess;
    private final String code;
    private final String message;
}
