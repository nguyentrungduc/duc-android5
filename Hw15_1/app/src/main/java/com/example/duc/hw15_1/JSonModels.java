package com.example.duc.hw15_1;

/**
 * Created by DUC on 10/26/2016.
 */
public class JSonModels{
    private String message;
    private int code;

    public JSonModels(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }
}
