package com.example.sergey_valevich.moxysample.di;

import com.example.sergey_valevich.moxysample.validation.view.EditCredsActivity;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {ApplicationModule.class, ModelModule.class})
public interface AppComponent {


    EditCredsActivity.CredsEditComponent plus(EditCredsActivity.CredsEditModule module);


    void inject(EditCredsActivity activity);
}
