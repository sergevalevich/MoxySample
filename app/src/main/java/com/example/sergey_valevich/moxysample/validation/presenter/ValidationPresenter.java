package com.example.sergey_valevich.moxysample.validation.presenter;

import com.arellomobile.mvp.MvpPresenter;
import com.example.sergey_valevich.moxysample.validation.model.ValidationModel;
import com.example.sergey_valevich.moxysample.validation.view.ValidationView;

public class ValidationPresenter extends MvpPresenter<ValidationView> {

    private ValidationModel validationModel;

    public ValidationPresenter (ValidationModel validationModel) {
        this.validationModel = validationModel;
    }

    protected void validate() {
        if (validationModel.isValid()) {
            getViewState().onInputValid();
        } else {
            getViewState().onInputInvalid(validationModel.errorMessage());
        }
    }

}
