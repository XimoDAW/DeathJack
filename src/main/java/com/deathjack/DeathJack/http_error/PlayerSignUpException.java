package com.deathjack.DeathJack.http_error;

public class PlayerSignUpException extends Exception{
    private String message;

    public PlayerSignUpException (String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
