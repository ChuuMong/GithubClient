package frogermcs.io.githubclient.di.splash;

import dagger.Module;
import dagger.Provides;
import frogermcs.io.githubclient.HeavyLibraryWrapper;
import frogermcs.io.githubclient.data.repository.UserRepository;
import frogermcs.io.githubclient.di.ActivityScope;
import frogermcs.io.githubclient.presenter.splash.SplashActivityPresenterImpl;
import frogermcs.io.githubclient.presenter.splash.SplashContract.SplashPresenter;
import frogermcs.io.githubclient.ui.activity.SplashActivity;
import frogermcs.io.githubclient.utils.Validator;

/**
 * Created by Miroslaw Stanek on 23.04.15.
 */
@Module
public class SplashActivityModule {

    private SplashActivity splashActivity;

    public SplashActivityModule(SplashActivity splashActivity) {
        this.splashActivity = splashActivity;
    }

    @Provides
    @ActivityScope
    SplashActivity provideSplashActivity() {
        return splashActivity;
    }

    @Provides
    @ActivityScope
    SplashPresenter provideSplashActivityPresenter(Validator validator, UserRepository userRepository,
                                                   HeavyLibraryWrapper heavyLibraryWrapper) {
        return new SplashActivityPresenterImpl(splashActivity, validator, userRepository, heavyLibraryWrapper);
    }
}