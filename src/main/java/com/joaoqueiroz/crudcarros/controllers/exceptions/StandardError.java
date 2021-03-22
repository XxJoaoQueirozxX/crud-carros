package com.joaoqueiroz.crudcarros.controllers.exceptions;

import java.io.Serializable;
import java.time.LocalDateTime;

public class StandardError implements Serializable {
    private final long serialVersionUID = 1L;


    private String error;
    private String message;
    private Integer code;
    private LocalDateTime timestamp;
    private String path;

    public StandardError() { }

    public StandardError(String message, String error, Integer code, LocalDateTime timestamp, String path) {
        this.message = message;
        this.error = error;
        this.code = code;
        this.timestamp = timestamp;
        this.path = path;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
