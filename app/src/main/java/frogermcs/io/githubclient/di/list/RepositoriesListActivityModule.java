package frogermcs.io.githubclient.di.list;

import android.support.v7.widget.LinearLayoutManager;

import java.util.Map;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntKey;
import dagger.multibindings.IntoMap;
import frogermcs.io.githubclient.data.repository.RepositoriesRepository;
import frogermcs.io.githubclient.data.model.Repository;
import frogermcs.io.githubclient.di.ActivityScope;
import frogermcs.io.githubclient.presenter.list.RepositoriesListContract.RepositoriesListPresenter;
import frogermcs.io.githubclient.presenter.list.RepositoriesListPresenterImpl;
import frogermcs.io.githubclient.ui.activity.RepositoriesListActivity;
import frogermcs.io.githubclient.ui.adapter.RepositoriesListAdapter;
import frogermcs.io.githubclient.ui.adapter.viewholder.RepositoriesListViewHolderFactory;
import frogermcs.io.githubclient.ui.adapter.viewholder.RepositoryViewHolderBigFactory;
import frogermcs.io.githubclient.ui.adapter.viewholder.RepositoryViewHolderFeaturedFactory;
import frogermcs.io.githubclient.ui.adapter.viewholder.RepositoryViewHolderNormalFactory;

/**
 * Created by Miroslaw Stanek on 23.04.15.
 */
@Module
public class RepositoriesListActivityModule {
    private RepositoriesListActivity repositoriesListActivity;

    public RepositoriesListActivityModule(RepositoriesListActivity repositoriesListActivity) {
        this.repositoriesListActivity = repositoriesListActivity;
    }

    @Provides
    @ActivityScope
    RepositoriesListActivity provideRepositoriesListActivity() {
        return repositoriesListActivity;
    }

    @Provides
    @ActivityScope
    RepositoriesListPresenter provideRepositoriesListActivityPresenter(RepositoriesRepository repositoriesRepository) {
        return new RepositoriesListPresenterImpl(repositoriesListActivity, repositoriesRepository);
    }

    @Provides
    @ActivityScope
    RepositoriesListAdapter provideRepositoriesListAdapter(RepositoriesListActivity repositoriesListActivity,
                                                           Map<Integer, RepositoriesListViewHolderFactory> viewHolderFactories) {
        return new RepositoriesListAdapter(repositoriesListActivity, viewHolderFactories);
    }

    @Provides
    @ActivityScope
    LinearLayoutManager provideLinearLayoutManager(RepositoriesListActivity repositoriesListActivity) {
        return new LinearLayoutManager(repositoriesListActivity);
    }

    @Provides
    @IntoMap
    @IntKey(Repository.TYPE_NORMAL)
    RepositoriesListViewHolderFactory provideViewHolderNormal() {
        return new RepositoryViewHolderNormalFactory();
    }

    @Provides
    @IntoMap
    @IntKey(Repository.TYPE_BIG)
    RepositoriesListViewHolderFactory provideViewHolderBig() {
        return new RepositoryViewHolderBigFactory();
    }

    @Provides
    @IntoMap
    @IntKey(Repository.TYPE_FEATURED)
    RepositoriesListViewHolderFactory provideViewHolderFeatured() {
        return new RepositoryViewHolderFeaturedFactory();
    }
}