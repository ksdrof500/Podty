package podcast.com.br.podtche;

import android.app.Application;
import android.content.Context;
import android.graphics.Point;
import android.os.Handler;
import android.view.Display;
import android.view.WindowManager;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.stetho.Stetho;

import podcast.com.br.podtche.inject.components.AppComponent;
import podcast.com.br.podtche.inject.components.DaggerAppComponent;
import podcast.com.br.podtche.inject.modules.AppModule;
import podcast.com.br.podtche.inject.modules.NetworkModule;


public class MainApplication extends Application {

    private AppComponent component;
    public static Context applicationContext = null;
    public static volatile Handler applicationHandler = null;
    public static Point displaySize = new Point();
    public static float density = 1;
    @Override
    public void onCreate() {

        super.onCreate();
        applicationContext = getApplicationContext();
        applicationHandler = new Handler(applicationContext.getMainLooper());

        checkDisplaySize();
        density = applicationContext.getResources().getDisplayMetrics().density;

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


    public static void checkDisplaySize() {
        try {
            WindowManager manager = (WindowManager) applicationContext.getSystemService(Context.WINDOW_SERVICE);
            if (manager != null) {
                Display display = manager.getDefaultDisplay();
                if (display != null) {
                    if (android.os.Build.VERSION.SDK_INT < 13) {
                        displaySize.set(display.getWidth(), display.getHeight());
                    } else {
                        display.getSize(displaySize);
                    }
                }
            }
        } catch (Exception e) {
        }
    }


    public static MainApplication getApplication(Context context) {
        return (MainApplication) context.getApplicationContext();
    }

    public AppComponent getComponent() {
        return component;
    }
}
