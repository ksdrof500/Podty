package podcast.com.br.podtche.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.ObservableBoolean;

import javax.inject.Inject;


import podcast.com.br.podtche.MainApplication;
import podcast.com.br.podtche.api.PodApi;
import podcast.com.br.podtche.data.AnalyticsManager;
import podcast.com.br.podtche.data.LoginManager;
import podcast.com.br.podtche.view.LoginView;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by fenrir on 18/03/16.
 */
public abstract class AuthenticationViewModel extends BaseObservable {

    private static final String SUCCESS_MESSAGE = "Subscribed With Success!";
    public ObservableBoolean showError = new ObservableBoolean();

    protected LoginView loginView;
    protected String expectedPin;
    protected String msisdn;

    @Inject
    protected PodApi recipesApi;

    @Inject
    protected LoginManager loginManager;

    @Inject
    protected AnalyticsManager analytics;

    public AuthenticationViewModel(Context context, LoginView loginView, String msisdn) {

        this.loginView = loginView;
        this.msisdn = msisdn;

        MainApplication.getApplication(context)
                .getComponent().inject(this);
    }

    protected void checkUserSubscription() {

        loginView.displayProgress();

//        recipesApi.getSubscriptionStatus(msisdn)
//                .subscribeOn(Schedulers.io())
//                .map(response -> response.message)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(message -> {
//                    if (loginManager.validate(message)) {
//                        login(true);
//                    } else if (message.equals("Subscription Pending!")) {
//                        loginView.displaySubscriptionPendingMessage();
//                        loginView.hideProgress();
//                    } else {
//                        subscribeUser();
//                    }
//                }, throwable -> {
//                    loginView.hideProgress();
//                    showError.set(true);
//                });
    }

    protected void subscribeUser() {
//
//        recipesApi.subscribe(msisdn)
//                .subscribeOn(Schedulers.io())
//                .map(response -> response.message)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(message -> {
//                    if (message.equals(SUCCESS_MESSAGE)) {
//                        login(false);
//                        loginView.displayCongratulations();
//                    } else {
//                        showError.set(true);
//                    }
//                    loginView.hideProgress();
//                }, throwable -> {
//                    showError.set(true);
//                    loginView.hideProgress();
//                });
    }

    protected void login(boolean closeAfter) {

        loginManager.login(msisdn);
        loginView.setOkResult();

        if (closeAfter) {
            loginView.close();
        }
    }
}
