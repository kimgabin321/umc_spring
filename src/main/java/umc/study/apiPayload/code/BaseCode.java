package umc.study.apiPayload.code;

public interface BaseCode {
    ReasonDTO getReason();             // 기본 이유 반환
    ReasonDTO getReasonHttpStatus();   // HTTP 상태 코드 포함 이유 반환
}
