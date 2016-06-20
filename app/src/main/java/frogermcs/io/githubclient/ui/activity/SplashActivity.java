package frogermcs.io.githubclient.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import frogermcs.io.githubclient.GithubClientApplication;
import frogermcs.io.githubclient.R;
import frogermcs.io.githubclient.data.model.User;
import frogermcs.io.githubclient.di.splash.SplashActivityModule;
import frogermcs.io.githubclient.presenter.splash.SplashContract.SplashPresenter;
import frogermcs.io.githubclient.presenter.splash.SplashContract.SplashView;
import frogermcs.io.githubclient.utils.AnalyticsManager;


public class SplashActivity extends BaseActivity implements SplashView {

    @Bind(R.id.etUsername)
    EditText etUsername;
    @Bind(R.id.pbLoading)
    ProgressBar pbLoading;
    @Bind(R.id.btnShowRepositories)
    Button btnShowRepositories;

    //These references will be satisfied by 'SplashActivityComponent.inject(this)' method
    @Inject
    SplashPresenter presenter;

    @Inject
    AnalyticsManager analyticsManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        analyticsManager.logScreenView(getClass().getName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    //Local dependencies graph is constructed here
    @Override
    protected void setupActivityComponent() {
        //Uncomment those lines do measure dependencies creation time
        //Debug.startMethodTracing("SplashTrace");
        GithubClientApplication.get(this).getAppComponent().plus(new SplashActivityModule(this)).inject(this);
        //Debug.stopMethodTracing();
    }

    @OnClick(R.id.btnShowRepositories)
    public void onShowRepositoriesClick() {
        presenter.onShowRepositoriesClick(etUsername.getText().toString());
    }

    @Override
    public void showRepositoriesListForUser(User user) {
        GithubClientApplication.get(this).createUserComponent(user);
        startActivity(new Intent(this, RepositoriesListActivity.class));
    }

    @Override
    public void showValidationError() {
        etUsername.setError("Validation error");
    }

    @Override
    public void showLoading(boolean loading) {
        btnShowRepositories.setVisibility(loading ? View.GONE : View.VISIBLE);
        pbLoading.setVisibility(loading ? View.VISIBLE : View.GONE);
    }
}
