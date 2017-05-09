package com.example.sergey_valevich.moxysample.validation.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.sergey_valevich.moxysample.MoxySampleApplication;
import com.example.sergey_valevich.moxysample.R;
import com.example.sergey_valevich.moxysample.validation.presenter.CredsEditPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;
import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;

public abstract class EditCredsActivity extends MvpAppCompatActivity implements ValidationView {

    public static final String ACTION_EDIT_PASS = "EDIT_PASS_ACTION";
    public static final String ACTION_EDIT_NAME = "EDIT_NAME_ACTION";

    @BindView(R.id.input_field)
    EditText inputField;

    @InjectPresenter
    CredsEditPresenter presenter;

    private boolean isValid;

    public static Intent newInstance(String input) {
        Intent intent = new Intent();
        intent.putExtra("INPUT", input);
        return intent;
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_creds);
        ButterKnife.bind(this);
        ((MoxySampleApplication) getApplicationContext())
                .getAppComponent()
                .inject(this);

        inputField.setText(getIntent().getStringExtra("INPUT"));
        presenter.setAction(getIntent().getAction());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_edit_creds, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.action_done).setEnabled(isValid);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_done:
                setResultAndFinish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setResultAndFinish() {
        final String input = inputField.getText().toString();
        Intent intent = new Intent();

        intent.putExtra("OUTPUT", input);
        intent.setAction(presenter.getAction());
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public void onInputValid() {
        isValid = true;
        invalidateOptionsMenu();
    }

    @Override
    public void onInputInvalid(String errorMessage) {
        isValid = false;
        invalidateOptionsMenu();
    }

    @OnTextChanged(value = R.id.input_field)
    void onInputChanged(CharSequence name) {
        presenter.onInputChanged(name.toString());
    }


    @Subcomponent(modules = CredsEditModule.class)
    public interface CredsEditComponent {

        CredsEditPresenter presenter();
    }

    @Module
    public static class CredsEditModule {

        @Provides
        @NonNull
        CredsEditPresenter providePresenter() {
            return new CredsEditPresenter();
        }
    }

    @ProvidePresenter
    public CredsEditPresenter providePresenter() {
        return ((MoxySampleApplication) getApplicationContext()).getAppComponent()
                .plus(new CredsEditModule())
                .presenter();
    }

}
