package mcnc.survwey.global.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    USER_NOT_FOUND_BY_EMAIL("해당 이메일의 사용자가 존재하지 않습니다."),
    INVALID_PASSWORD("비밀번호가 일치하지 않습니다.");
    USER_ALREADY_EXISTS("해당 이메일의 사용자가 이미 존재합니다.");
    private final String errorMessage;

    ErrorCode(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
