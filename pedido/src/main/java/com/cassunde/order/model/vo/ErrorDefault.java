package com.cassunde.order.model.vo;

import java.io.Serializable;

public class ErrorDefault implements Serializable {

    private String message;
    private String code;

    public ErrorDefault(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
