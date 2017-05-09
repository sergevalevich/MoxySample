package com.example.sergey_valevich.moxysample.validation.presenter;

import com.example.sergey_valevich.moxysample.validation.model.Name;
import com.example.sergey_valevich.moxysample.validation.model.Password;
import com.example.sergey_valevich.moxysample.validation.model.ValidationModel;

import static com.example.sergey_valevich.moxysample.validation.view.EditCredsActivity.ACTION_EDIT_NAME;
import static com.example.sergey_valevich.moxysample.validation.view.EditCredsActivity.ACTION_EDIT_PASS;

public class CredsEditPresenter extends ValidationPresenter {

    private String action;

    public CredsEditPresenter(ValidationModel validationModel) {
        super(validationModel);
    }

    public void onInputChanged(String s) {
        validatable.setValue(s);
        validate();
        // FIXME: 08.05.2017 HOW TO RESET VALIDATABLE'S Values???
    }

    private Validatable createValidatable() {
        Validatable v = null;
        if (ACTION_EDIT_PASS.equals(action)) {
            v = new Name();
        } else if (ACTION_EDIT_NAME.equals(action)) {
            v = new Password();
        }
        return v;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }
}
