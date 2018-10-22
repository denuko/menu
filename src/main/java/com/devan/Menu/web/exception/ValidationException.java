package com.devan.Menu.web.exception;

import lombok.Getter;
import org.springframework.validation.BindingResult;

@Getter
public class ValidationException extends Exception {

    private BindingResult result;

    public ValidationException(BindingResult result) {
        super();
        this.result = result;
    }
}
