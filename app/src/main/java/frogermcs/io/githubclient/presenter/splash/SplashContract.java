package frogermcs.io.githubclient.presenter.splash;


import frogermcs.io.githubclient.data.model.User;
import frogermcs.io.githubclient.presenter.Presenter;
import frogermcs.io.githubclient.presenter.View;

/**
 * Created by LeeJongHun on 2016-06-20.
 */
public interface SplashContract {

    interface SplashView extends View {


        void showRepositoriesListForUser(User user);

        void showValidationError();
    }

    interface SplashPresenter extends Presenter {

        void onShowRepositoriesClick(String userName);
    }
}
