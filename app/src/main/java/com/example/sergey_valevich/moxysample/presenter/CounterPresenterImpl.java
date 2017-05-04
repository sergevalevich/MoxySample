package com.example.sergey_valevich.moxysample.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.example.sergey_valevich.moxysample.model.CounterInteractorImpl;
import com.example.sergey_valevich.moxysample.view.CounterView;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import timber.log.Timber;

@InjectViewState
public class CounterPresenterImpl extends AbstractPresenter<CounterView> implements AppBasePresenter {

    private final CounterInteractorImpl interactor;

    public CounterPresenterImpl(final CounterInteractorImpl interactor) {
        this.interactor = interactor;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        Timber.d("OnFirstViewAttach");
    }

    public void startCounter() {
        final Subscription subscription = interactor.tick()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        (second) -> getViewState().showCurrentSecond(second),
                        this::handleError);

        addSubscription(subscription);
    }

    public void onPaintScreen() {
        getViewState().paintScreen();
    }

}
