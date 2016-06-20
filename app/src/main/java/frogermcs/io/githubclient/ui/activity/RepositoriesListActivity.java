package frogermcs.io.githubclient.ui.activity;

import com.google.common.collect.ImmutableList;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import frogermcs.io.githubclient.GithubClientApplication;
import frogermcs.io.githubclient.R;
import frogermcs.io.githubclient.data.model.Repository;
import frogermcs.io.githubclient.di.list.RepositoriesListActivityModule;
import frogermcs.io.githubclient.presenter.list.RepositoriesListContract.RepositoriesListPresenter;
import frogermcs.io.githubclient.presenter.list.RepositoriesListContract.RepositoriesListView;
import frogermcs.io.githubclient.ui.adapter.RepositoriesListAdapter;


public class RepositoriesListActivity extends BaseActivity implements RepositoriesListView {

    @Bind(R.id.rvRepositories)
    RecyclerView rvRepositories;
    @Bind(R.id.pbLoading)
    ProgressBar pbLoading;

    @Inject
    RepositoriesListPresenter presenter;
    @Inject
    RepositoriesListAdapter repositoriesListAdapter;
    @Inject
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repositories_list);
        ButterKnife.bind(this);
        setupRepositoriesListView();
        presenter.loadRepositories();
    }

    private void setupRepositoriesListView() {
        rvRepositories.setAdapter(repositoriesListAdapter);
        rvRepositories.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected void setupActivityComponent() {
        GithubClientApplication.get(this).getUserComponent().plus(new RepositoriesListActivityModule(this)).inject(this);
    }

    @Override
    public void showLoading(boolean loading) {
        rvRepositories.setVisibility(loading ? View.GONE : View.VISIBLE);
        pbLoading.setVisibility(loading ? View.VISIBLE : View.GONE);
    }

    @Override
    public void setRepositories(ImmutableList<Repository> repositories) {
        repositoriesListAdapter.updateRepositoriesList(repositories);
    }

    public void onRepositoryClick(Repository repository) {
        RepositoryDetailsActivity.startWithRepository(repository, this);
    }

    @Override
    public void finish() {
        super.finish();
        GithubClientApplication.get(this).releaseUserComponent();
    }
}
