package frogermcs.io.githubclient.presenter.splash;

import frogermcs.io.githubclient.HeavyLibraryWrapper;
import frogermcs.io.githubclient.data.repository.UserRepository;
import frogermcs.io.githubclient.data.model.User;
import frogermcs.io.githubclient.presenter.splash.SplashContract.SplashPresenter;
import frogermcs.io.githubclient.presenter.splash.SplashContract.SplashView;
import frogermcs.io.githubclient.utils.SimpleObserver;
import frogermcs.io.githubclient.utils.Validator;

/**
 * Created by Miroslaw Stanek on 23.04.15.
 */
public class SplashActivityPresenterImpl implements SplashPresenter {

    private SplashView view;
    private Validator validator;
    private UserRepository userRepository;
    private HeavyLibraryWrapper heavyLibraryWrapper;

    public SplashActivityPresenterImpl(SplashView view, Validator validator, UserRepository userRepository,
                                       HeavyLibraryWrapper heavyLibraryWrapper) {

        this.view = view;
        this.validator = validator;
        this.userRepository = userRepository;
        this.heavyLibraryWrapper = heavyLibraryWrapper;

        // This calls should be delivered to ExternalLibrary right after it will be initialized
        this.heavyLibraryWrapper.callMethod();
        this.heavyLibraryWrapper.callMethod();
        this.heavyLibraryWrapper.callMethod();
        this.heavyLibraryWrapper.callMethod();
    }

    @Override
    public void onShowRepositoriesClick(String userName) {
        if (validator.validUsername(userName)) {
            view.showLoading(true);
            userRepository.getUser(userName).subscribe(new SimpleObserver<User>() {
                @Override
                public void onNext(User user) {
                    view.showLoading(false);
                    view.showRepositoriesListForUser(user);
                }

                @Override
                public void onError(Throwable e) {
                    view.showLoading(false);
                    view.showValidationError();
                }
            });
        }
        else {
            view.showValidationError();
        }
    }
}
