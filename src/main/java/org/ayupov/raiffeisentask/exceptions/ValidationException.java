package org.ayupov.raiffeisentask.exceptions;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@AllArgsConstructor
@NoArgsConstructor

public class ValidationException extends RuntimeException{

    private ValidationErrorCode error;

    public ValidationErrorCode getError() {
        return error;
    }
}