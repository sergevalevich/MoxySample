package com.example.sergey_valevich.moxysample.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

//@StateStrategyType(SingleStateStrategy.class)
public interface CounterView extends MvpView, AppBaseView {

    void showCurrentSecond(Long second);

    void paintScreen();
}
