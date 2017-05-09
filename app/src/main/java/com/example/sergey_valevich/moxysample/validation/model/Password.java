package com.example.sergey_valevich.moxysample.validation.model;


import android.text.TextUtils;

public class Password implements Validatable {

    private String password;

    private String errorMessage;

    @Override
    public boolean isValid() {
        if (TextUtils.isEmpty(password)) {
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
