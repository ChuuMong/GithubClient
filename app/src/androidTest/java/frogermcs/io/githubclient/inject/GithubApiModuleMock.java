package frogermcs.io.githubclient.inject;

import frogermcs.io.githubclient.data.api.GithubApiModule;
import frogermcs.io.githubclient.data.api.GithubApiService;
import frogermcs.io.githubclient.data.repository.UserRepository;

/**
 * Created by Miroslaw Stanek on 23.09.15.
 */
public class GithubApiModuleMock extends GithubApiModule {

    private UserRepository userRepositoryMock;

    public GithubApiModuleMock(UserRepository userRepositoryMock) {
        this.userRepositoryMock = userRepositoryMock;
    }

    @Override
    public UserRepository provideUserManager(GithubApiService githubApiService) {
        return userRepositoryMock;
    }
}
