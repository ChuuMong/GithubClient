package frogermcs.io.githubclient.di.splash;

import dagger.Subcomponent;
import frogermcs.io.githubclient.di.ActivityScope;
import frogermcs.io.githubclient.ui.activity.SplashActivity;

/**
 * Created by Miroslaw Stanek on 23.04.15.
 */
@ActivityScope
@Subcomponent(modules = SplashActivityModule.class)
public interface SplashActivityComponent {

    SplashActivity inject(SplashActivity splashActivity);

}