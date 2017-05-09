package com.example.sergey_valevich.moxysample.validation.model;


import android.text.TextUtils;

public class Creds implements Validatable {

    private String name;
    private String password;

    private String errorMessage;

    @Override
    public boolean isValid() {
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(password)) {
            errorMessage = "LOX";
            return false;
        }
        return true;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}
