package org.ayupov.raiffeisentask.exceptions;

import org.springframework.http.HttpStatus;

public enum ValidationErrorCode {
    INCORRECT_PARAMS(HttpStatus.BAD_REQUEST),
    SERVER_CRASH(HttpStatus.INTERNAL_SERVER_ERROR);

    private HttpStatus statusError;

    ValidationErrorCode(HttpStatus statusError) {
        this.statusError = statusError;
    }

    public HttpStatus getStatusError() {
        return statusError;
    }
}
