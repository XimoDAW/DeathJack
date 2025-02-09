package com.deathjack.DeathJack.http_error;

public class DuplicateObjectException extends Exception{
    private String message;

    public DuplicateObjectException (String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
