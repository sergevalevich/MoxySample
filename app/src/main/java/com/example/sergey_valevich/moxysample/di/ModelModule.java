package com.example.sergey_valevich.moxysample.di;

import com.example.sergey_valevich.moxysample.model.NameValidationModel;
import com.example.sergey_valevich.moxysample.model.PassValidationModel;
import com.example.sergey_valevich.moxysample.model.ValidationModel;

import javax.inject.Qualifier;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public final class ModelModule {

//    @Singleton
//    @Provides
//    static ValidationModel providesNameValidatonModel() {
//        return new NameValidationModel("");
//    }
//
//    @Singleton
//    @Provides
//    static ValidationModel providesPassValidatonModel() {
//        return new PassValidationModel();
//    }
}
