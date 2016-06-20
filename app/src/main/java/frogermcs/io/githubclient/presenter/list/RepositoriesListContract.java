package frogermcs.io.githubclient.presenter.list;

import com.google.common.collect.ImmutableList;

import frogermcs.io.githubclient.data.model.Repository;
import frogermcs.io.githubclient.presenter.Presenter;
import frogermcs.io.githubclient.presenter.View;

/**
 * Created by LeeJongHun on 2016-06-20.
 */
public interface RepositoriesListContract {

    interface RepositoriesListView extends View {

        void setRepositories(ImmutableList<Repository> repositories);
    }

    interface RepositoriesListPresenter extends Presenter {

        void loadRepositories();
    }
}
