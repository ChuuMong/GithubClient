package frogermcs.io.githubclient.di.detail;

import dagger.Module;
import dagger.Provides;
import frogermcs.io.githubclient.data.model.User;
import frogermcs.io.githubclient.di.ActivityScope;
import frogermcs.io.githubclient.presenter.detail.RepositoryDetailsConract.RepositoryDetailsPresenter;
import frogermcs.io.githubclient.presenter.detail.RepositoryDetailsPresenterImpl;
import frogermcs.io.githubclient.ui.activity.RepositoryDetailsActivity;

/**
 * Created by Miroslaw Stanek on 23.04.15.
 */
@Module
public class RepositoryDetailsActivityModule {

    private RepositoryDetailsActivity repositoryDetailsActivity;

    public RepositoryDetailsActivityModule(RepositoryDetailsActivity repositoryDetailsActivity) {
        this.repositoryDetailsActivity = repositoryDetailsActivity;
    }

    @Provides
    @ActivityScope
    RepositoryDetailsActivity provideRepositoryDetailsActivity() {
        return repositoryDetailsActivity;
    }

    @Provides
    @ActivityScope
    RepositoryDetailsPresenter provideRepositoryDetailsActivityPresenter(User user) {
        return new RepositoryDetailsPresenterImpl(repositoryDetailsActivity, user);
    }
}