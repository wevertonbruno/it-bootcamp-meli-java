package br.com.meli.spring2pratica1.controllers.DTO;

import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.time.Instant;

public class ErrorDTO implements Serializable {
    private String message;
    private Instant time;
    private Integer statusCode;

    public ErrorDTO(String message, HttpStatus statusCode) {
        this.message = message;
        this.time = Instant.now();
        this.statusCode = statusCode.value();
    }

    public String getMessage() {
        return message;
    }

    public Instant getTime() {
        return time;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    @Override
    public String toString() {
        return "ErrorDTO{" +
                "message='" + message + '\'' +
                ", time=" + time +
                ", statusCode=" + statusCode +
                '}';
    }
}
