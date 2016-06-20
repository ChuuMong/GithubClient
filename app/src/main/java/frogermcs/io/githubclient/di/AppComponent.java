package frogermcs.io.githubclient.di;

import javax.inject.Singleton;

import dagger.Component;
import frogermcs.io.githubclient.di.user.UserComponent;
import frogermcs.io.githubclient.data.api.GithubApiModule;
import frogermcs.io.githubclient.di.user.UserModule;
import frogermcs.io.githubclient.di.splash.SplashActivityComponent;
import frogermcs.io.githubclient.di.splash.SplashActivityModule;

/**
 * Created by Miroslaw Stanek on 22.04.15.
 */
@Singleton
@Component(modules = {AppModule.class, GithubApiModule.class})
public interface AppComponent {

    SplashActivityComponent plus(SplashActivityModule module);

    UserComponent plus(UserModule userModule);

}