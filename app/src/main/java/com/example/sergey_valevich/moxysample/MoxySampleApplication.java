package com.example.sergey_valevich.moxysample;

import android.app.Application;

import com.example.sergey_valevich.moxysample.di.AppComponent;
import com.example.sergey_valevich.moxysample.di.ApplicationModule;
import com.example.sergey_valevich.moxysample.di.DaggerAppComponent;
import com.squareup.leakcanary.LeakCanary;

import timber.log.Timber;

public class MoxySampleApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        if (!LeakCanary.isInAnalyzerProcess(this)) {
            LeakCanary.install(this);
        }
    }

    public AppComponent getAppComponent() {
        if (appComponent == null) {
            appComponent = createComponent();
        }
        return appComponent;
    }

    private AppComponent createComponent() {
        return DaggerAppComponent.builder().applicationModule(new ApplicationModule(this)).build();
    }
}
