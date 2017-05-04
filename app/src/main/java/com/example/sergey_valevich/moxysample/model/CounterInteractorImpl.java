package com.example.sergey_valevich.moxysample.model;

import java.util.concurrent.TimeUnit;

import rx.Observable;


public class CounterInteractorImpl implements CounterInteractor {

    private final int timeToLive;

    public CounterInteractorImpl(final int timeToLive) {
        this.timeToLive = timeToLive;
    }

    @Override
    public Observable<Long> tick() {
        return Observable.interval(1,TimeUnit.SECONDS).take(timeToLive);
    }

}
