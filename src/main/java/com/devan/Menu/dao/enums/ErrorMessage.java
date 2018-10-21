package com.devan.Menu.dao.enums;

import lombok.Getter;

@Getter
public enum ErrorMessage {
    NOT_FOUND("Entity not found with id: "),
    INVALID("Invalid field: ");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }
}
