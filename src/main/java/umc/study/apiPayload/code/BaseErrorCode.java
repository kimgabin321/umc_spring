package umc.study.apiPayload.code;

public interface BaseErrorCode<ErrorReason> {

    ErrorReason getReason();

    ErrorReason getReasonHttpStatus();
}
