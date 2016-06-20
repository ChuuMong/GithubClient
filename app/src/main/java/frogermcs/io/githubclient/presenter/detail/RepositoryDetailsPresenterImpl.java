package frogermcs.io.githubclient.presenter.detail;

import frogermcs.io.githubclient.data.model.User;
import frogermcs.io.githubclient.presenter.detail.RepositoryDetailsConract.RepositoryDetailsPresenter;
import frogermcs.io.githubclient.presenter.detail.RepositoryDetailsConract.RepositoryDetailsView;

/**
 * Created by Miroslaw Stanek on 23.04.15.
 */
public class RepositoryDetailsPresenterImpl implements RepositoryDetailsPresenter {

    private RepositoryDetailsView view;
    private User user;

    public RepositoryDetailsPresenterImpl(RepositoryDetailsView view, User user) {
        this.view = view;
        this.user = user;
    }

    @Override
    public void init() {
        view.setupUserName(user.login);
    }
}
