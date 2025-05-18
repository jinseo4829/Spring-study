package umc.spring.study.apiPayload.exception.handler;

import umc.spring.study.apiPayload.code.status.ErrorStatus;

public class MemberHandler extends RuntimeException {
    private final ErrorStatus errorStatus;

    public MemberHandler(ErrorStatus errorStatus) {
        this.errorStatus = errorStatus;
    }

    public ErrorStatus getErrorStatus() {
        return errorStatus;
    }
}
