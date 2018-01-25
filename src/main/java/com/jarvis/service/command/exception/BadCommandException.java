package com.jarvis.service.command.exception;

public class BadCommandException extends RuntimeException{
    @Override
    public String getMessage() {
        return "Cannot resolve this command";
    }
}
