package com.example.sergey_valevich.moxysample.validation.view;

import com.arellomobile.mvp.MvpView;

//@StateStrategyType(SingleStateStrategy.class)
public interface ValidationView extends MvpView {

    void onInputValid();
    void onInputInvalid(String errorMessage);
}
