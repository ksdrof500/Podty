package podcast.com.br.podtche.inject.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import podcast.com.br.podtche.MainApplication;
import podcast.com.br.podtche.data.FavoritesRepository;
import podcast.com.br.podtche.data.LoginManager;

/**
 * Created by gholz on 2/13/16.
 */
@Module
public class AppModule {

    private MainApplication application;

    public AppModule(MainApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public MainApplication provideApplication() {
        return application;
    }

//    @Provides
//    @Singleton
//    public FontManager provideFontManager() {
//        return new FontManager(application);
//    }

    @Provides
    @Singleton
    public FavoritesRepository provideFavoritesRepository() {
        return new FavoritesRepository(application);
    }

    @Provides
    @Singleton
    public LoginManager provideLoginManager() {
        return new LoginManager(application);
    }

//    @Provides
//    @Singleton
//    public WrenManger provideWrenManager() { return new WrenManger(application); }

//    @Provides
//    @Singleton
//    public Tracker provideTracker(GoogleAnalytics analytics) {
//        return analytics.newTracker("UA-85138273-1");
//    }
//
//    @Provides
//    @Singleton
//    public GoogleAnalytics provideAnalytics() {
//        return GoogleAnalytics.getInstance(application);
//    }
//
//    @Provides
//    @Singleton
//    public AnalyticsManager provideAnalyticsManager(FirebaseAnalytics tracker) {
//        return new AnalyticsManager(tracker);
//    }
}
