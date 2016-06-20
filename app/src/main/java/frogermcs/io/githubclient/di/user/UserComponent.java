package frogermcs.io.githubclient.di.user;

import dagger.Subcomponent;
import frogermcs.io.githubclient.di.detail.RepositoryDetailsActivityComponent;
import frogermcs.io.githubclient.di.detail.RepositoryDetailsActivityModule;
import frogermcs.io.githubclient.di.list.RepositoriesListActivityComponent;
import frogermcs.io.githubclient.di.list.RepositoriesListActivityModule;

/**
 * Created by Miroslaw Stanek on 23.06.15.
 */
@UserScope
@Subcomponent(
        modules = {
                UserModule.class
        }
)
public interface UserComponent {

    RepositoriesListActivityComponent plus(RepositoriesListActivityModule module);

    RepositoryDetailsActivityComponent plus(RepositoryDetailsActivityModule module);
}