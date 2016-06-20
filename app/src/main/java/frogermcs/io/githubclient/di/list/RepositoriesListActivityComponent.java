package frogermcs.io.githubclient.di.list;

import dagger.Subcomponent;
import frogermcs.io.githubclient.di.ActivityScope;
import frogermcs.io.githubclient.ui.activity.RepositoriesListActivity;

/**
 * Created by Miroslaw Stanek on 23.04.15.
 */
@ActivityScope
@Subcomponent(
        modules = RepositoriesListActivityModule.class
)
public interface RepositoriesListActivityComponent {

    RepositoriesListActivity inject(RepositoriesListActivity repositoriesListActivity);

}