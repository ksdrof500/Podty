package podcast.com.br.podtche;

import android.app.Application;
import android.content.Context;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.stetho.Stetho;

import podcast.com.br.podtche.inject.components.AppComponent;
import podcast.com.br.podtche.inject.components.DaggerAppComponent;
import podcast.com.br.podtche.inject.modules.AppModule;
import podcast.com.br.podtche.inject.modules.NetworkModule;


public class MainApplication extends Application {

    private AppComponent component;

    @Override
    public void onCreate() {

        super.onCreate();

//        OneSignal.startInit(this)
//                .autoPromptLocation(true)
//                .setNotificationOpenedHandler(new NotificationOpenedHandler())
//                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
//                .init();

        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .build();

        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this);
        }

        FacebookSdk.sdkInitialize(this);
        AppEventsLogger.activateApp(this);



//        Bugsnag.init(this, "a1537a8cf00475f5c74286e565be96e2");
    }

    public static MainApplication getApplication(Context context) {
        return (MainApplication) context.getApplicationContext();
    }

    public AppComponent getComponent() {
        return component;
    }
}
