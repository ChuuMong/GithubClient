package frogermcs.io.githubclient;

import android.app.Application;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import frogermcs.io.githubclient.di.AppModule;
import frogermcs.io.githubclient.utils.AnalyticsManager;

/**
 * Created by Miroslaw Stanek on 20.09.15.
 */
public class MockAppModule extends AppModule {
    @Mock
    AnalyticsManager analyticsManagerMock;

    public MockAppModule(Application application) {
        super(application);
        MockitoAnnotations.initMocks(this);
    }

    @Override
    public AnalyticsManager provideAnalyticsManager() {
        return analyticsManagerMock;
    }
}