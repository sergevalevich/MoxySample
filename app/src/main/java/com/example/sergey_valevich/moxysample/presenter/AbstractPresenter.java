package com.example.sergey_valevich.moxysample.presenter;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.sergey_valevich.moxysample.view.AppBaseView;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public abstract class AbstractPresenter<V extends MvpView> extends MvpPresenter<V> {

    private final CompositeSubscription compositeSubscription = new CompositeSubscription();

    protected void addSubscription(@NonNull final Subscription subscription) {
        compositeSubscription.add(subscription);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        compositeSubscription.clear();
    }

    protected void handleError(final Throwable throwable, final String message) {
        if (getViewState() instanceof AppBaseView) {
            ((AppBaseView) getViewState()).hideProgress();
            ((AppBaseView) getViewState()).showError(!TextUtils.isEmpty(message) ? message : throwable.getMessage());
        }
    }

    protected void handleError(final Throwable throwable) {
        handleError(throwable, null);
    }
}
