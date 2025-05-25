package umc.spring.study.apiPayload.exception.handler;

import lombok.Getter;
import umc.spring.study.apiPayload.code.BaseErrorCode;
import umc.spring.study.apiPayload.exception.GeneralException;

@Getter
public class ValidPageHandler extends GeneralException {

    public ValidPageHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
