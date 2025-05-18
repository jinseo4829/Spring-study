package umc.spring.study.apiPayload.exception.handler;

import umc.spring.study.apiPayload.code.status.ErrorStatus;

public class StoreHandler extends RuntimeException {
  private final ErrorStatus errorStatus;

  public StoreHandler(ErrorStatus errorStatus) {
    this.errorStatus = errorStatus;
  }

  public ErrorStatus getErrorStatus() {
    return errorStatus;
  }
}

