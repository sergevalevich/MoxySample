package com.example.sergey_valevich.moxysample.di;

import android.app.Application;
import android.support.annotation.NonNull;

import com.example.sergey_valevich.moxysample.MoxySampleApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final MoxySampleApplication application;

    public ApplicationModule (final MoxySampleApplication application) {
        this.application = application;
    }

    @NonNull
    @Provides
    @Singleton
    MoxySampleApplication providesAppilication() {
        return application;
    }
}
