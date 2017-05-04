package com.example.sergey_valevich.moxysample.di;

import com.example.sergey_valevich.moxysample.MoxySampleApplication;
import com.example.sergey_valevich.moxysample.model.ModelModule;
import com.example.sergey_valevich.moxysample.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {ApplicationModule.class, ModelModule.class})
public interface AppComponent {

    MoxySampleApplication application();

    MainActivity.CounterComponent plus(MainActivity.CounterModule counterModule);

    void inject(MainActivity activity);

}
