package com.example.spring3pratica1.controllers.exceptions;

import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.time.Instant;

public class StandardException implements Serializable {
    private Integer status;
    private String msg;
    private Instant timestamp;
    private String path;

    public StandardException(Integer status, String msg, Instant timestamp, String path) {
        this.status = status;
        this.msg = msg;
        this.timestamp = timestamp;
        this.path = path;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public static StandardException notFound(String msg, String path){
        return new StandardException(HttpStatus.NOT_FOUND.value(), msg, Instant.now(), path);
    }

    @Override
    public String toString() {
        return "StandardException{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", timestamp=" + timestamp +
                ", path='" + path + '\'' +
                '}';
    }
}