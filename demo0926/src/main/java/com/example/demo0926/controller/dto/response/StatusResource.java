package com.example.demo0926.controller.dto.response;

public class StatusResource {
    private String message;

    public StatusResource(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
