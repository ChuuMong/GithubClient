package frogermcs.io.githubclient.presenter.detail;

import frogermcs.io.githubclient.presenter.Presenter;
import frogermcs.io.githubclient.presenter.View;

/**
 * Created by LeeJongHun on 2016-06-20.
 */
public interface RepositoryDetailsConract {

    interface RepositoryDetailsView extends View {

        void setupUserName(String login);
    }

    interface RepositoryDetailsPresenter extends Presenter {

        void init();
    }
}
