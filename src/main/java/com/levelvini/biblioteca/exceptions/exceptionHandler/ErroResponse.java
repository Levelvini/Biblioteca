package com.levelvini.biblioteca.exceptions.exceptionHandler;

import java.time.LocalDateTime;

public class ErroResponse {
    private LocalDateTime timestamp;
    private String message;
    private String status;

    public ErroResponse(LocalDateTime timestamp, String message, String status) {
        this.timestamp = timestamp;
        this.message = message;
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
