package umc.study.apiPayload.code;

public class ReasonHttpStatus {
    private final String code;    // 상태 코드
    private final String message; // 상태 메시지

    public ReasonHttpStatus(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
