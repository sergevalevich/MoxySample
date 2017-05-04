package com.example.sergey_valevich.moxysample.model;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public final class ModelModule {

    @Singleton
    @Provides
    static CounterInteractorImpl providesCounterInteractor() {
        return new CounterInteractorImpl(30);
    }
}
