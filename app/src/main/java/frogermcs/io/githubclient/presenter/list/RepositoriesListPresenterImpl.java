package frogermcs.io.githubclient.presenter.list;

import com.google.common.collect.ImmutableList;

import frogermcs.io.githubclient.data.repository.RepositoriesRepository;
import frogermcs.io.githubclient.data.model.Repository;
import frogermcs.io.githubclient.presenter.list.RepositoriesListContract.RepositoriesListPresenter;
import frogermcs.io.githubclient.presenter.list.RepositoriesListContract.RepositoriesListView;
import frogermcs.io.githubclient.utils.SimpleObserver;

/**
 * Created by Miroslaw Stanek on 23.04.15.
 */
public class RepositoriesListPresenterImpl implements RepositoriesListPresenter {

    private RepositoriesListView view;
    private RepositoriesRepository repositoriesRepository;

    public RepositoriesListPresenterImpl(RepositoriesListView view, RepositoriesRepository repositoriesRepository) {
        this.view = view;
        this.repositoriesRepository = repositoriesRepository;
    }

    @Override
    public void loadRepositories() {
        view.showLoading(true);
        repositoriesRepository.getUsersRepositories().subscribe(new SimpleObserver<ImmutableList<Repository>>() {
            @Override
            public void onNext(ImmutableList<Repository> repositories) {
                view.showLoading(false);
                view.setRepositories(repositories);
            }

            @Override
            public void onError(Throwable e) {
                view.showLoading(false);
            }
        });
    }

}
