package frogermcs.io.githubclient.di.detail;

import dagger.Subcomponent;
import frogermcs.io.githubclient.di.ActivityScope;
import frogermcs.io.githubclient.ui.activity.RepositoryDetailsActivity;

/**
 * Created by Miroslaw Stanek on 23.04.15.
 */
@ActivityScope
@Subcomponent(
        modules = RepositoryDetailsActivityModule.class
)
public interface RepositoryDetailsActivityComponent {

    RepositoryDetailsActivity inject(RepositoryDetailsActivity repositoryDetailsActivity);

}