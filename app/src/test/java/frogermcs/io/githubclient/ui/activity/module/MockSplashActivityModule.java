package frogermcs.io.githubclient.ui.activity.module;

import dagger.Provides;
import frogermcs.io.githubclient.data.repository.UserRepository;
import frogermcs.io.githubclient.di.ActivityScope;
import frogermcs.io.githubclient.di.splash.SplashActivityModule;
import frogermcs.io.githubclient.presenter.splash.SplashActivityPresenterImpl;
import frogermcs.io.githubclient.ui.activity.SplashActivity;
import frogermcs.io.githubclient.utils.Validator;

import static org.mockito.Mockito.mock;

/**
 * Created by Miroslaw Stanek on 20.09.15.
 */
public class MockSplashActivityModule extends SplashActivityModule {

    public MockSplashActivityModule(SplashActivity splashActivity) {
        super(splashActivity);
    }

    @Provides
    @ActivityScope
    SplashActivityPresenterImpl provideSplashActivityPresenter(Validator validator, UserRepository userRepository) {
        return mock(SplashActivityPresenterImpl.class);
    }
}
