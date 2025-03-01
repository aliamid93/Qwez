package com.example.qwez.ui.splash;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.example.qwez.R;
import com.example.qwez.base.BaseActivity;
import com.example.qwez.databinding.ActivitySplashBinding;
import com.example.qwez.entity.ErrorCarrier;
import com.google.firebase.auth.FirebaseUser;

import javax.inject.Inject;

import timber.log.Timber;

public class SplashActivity extends BaseActivity<ActivitySplashBinding> {

    @Inject
    SplashVMFactory factory;
    SplashViewModel viewModel;

    /**
     * Create BaseActivity with {@code binding} layout binding
     *
     * @param binding the layout binding
     */
    public SplashActivity(ActivitySplashBinding binding) {
        super(binding);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        hideToolbar();

        viewModel = ViewModelProviders.of(this, factory).get(SplashViewModel.class);
        viewModel.progress().observe(this, this::onProgress);
        viewModel.error().observe(this, this::onError);
        viewModel.user().observe(this, this::onUser);

        viewModel.getUser();

    }

    private void onUser(FirebaseUser firebaseUser) {
        Timber.d("onUser");
        if(firebaseUser != null){
            viewModel.openStart(this);
        }else{
            viewModel.openLogin(this);
        }
    }

    private void onError(ErrorCarrier errorCarrier) {
    }

    private void onProgress(Boolean aBoolean) {
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_splash;
    }
}
