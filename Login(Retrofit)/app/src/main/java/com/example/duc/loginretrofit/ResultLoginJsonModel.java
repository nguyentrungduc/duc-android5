package com.example.duc.loginretrofit;

import com.google.gson.annotations.SerializedName;

/**
 * Created by DUC on 11/5/2016.
 */
public class ResultLoginJsonModel {
    @SerializedName("code")
    private String code;

    public String getCode() {
        return code;
    }

    public boolean isSuccessful(){
        return ("1".equals(code));
    }
}
