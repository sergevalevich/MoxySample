package com.example.sergey_valevich.moxysample.view;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.PresenterType;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.sergey_valevich.moxysample.MoxySampleApplication;
import com.example.sergey_valevich.moxysample.R;
import com.example.sergey_valevich.moxysample.model.CounterInteractorImpl;
import com.example.sergey_valevich.moxysample.presenter.CounterPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;
import timber.log.Timber;

public class MainActivity extends MvpAppCompatActivity implements CounterView {

    @InjectPresenter(type = PresenterType.GLOBAL, tag = "counterPresenter")
    CounterPresenterImpl counterPresenter;

    @BindView(R.id.text)
    TextView textView;

    @BindView(R.id.paintScreen)
    TextView paintLink;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.root)
    ConstraintLayout rootView;

    @Override
    public void showError(final String message) {
        textView.setText(message);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showCurrentSecond(final Long second) {
        textView.setText(String.valueOf(second));
    }

    @Override
    public void paintScreen() {
        rootView.setBackgroundColor(Color.RED);
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ((MoxySampleApplication) getApplicationContext())
                .getAppComponent()
                .inject(this);
        Timber.d("OnCreate. bundle is %s", savedInstanceState);

        hideProgress();

    }

    @OnClick(R.id.text)
    void onTextClicked() {
        counterPresenter.startCounter();
    }

    @OnClick(R.id.paintScreen)
    void onPaintScreenClicked() {
        counterPresenter.onPaintScreen();
    }

    @Subcomponent(modules = CounterModule.class)
    public interface CounterComponent {

        CounterPresenterImpl presenter();
    }

    @Module
    public static class CounterModule {

        @Provides
        @NonNull
        CounterPresenterImpl providePresenter(@NonNull final CounterInteractorImpl interactor) {
            return new CounterPresenterImpl(interactor);
        }
    }

    @ProvidePresenter(type = PresenterType.GLOBAL, tag = "counterPresenter")
    public CounterPresenterImpl providePresenter() {
        return ((MoxySampleApplication) getApplicationContext()).getAppComponent()
                .plus(new CounterModule())
                .presenter();
    }

}
