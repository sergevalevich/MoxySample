package com.example.sergey_valevich.moxysample.model;

import rx.Observable;

public interface CounterInteractor {
    Observable<Long> tick();
}
