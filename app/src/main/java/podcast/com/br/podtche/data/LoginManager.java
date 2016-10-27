package podcast.com.br.podtche.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import podcast.com.br.podtche.MainApplication;
import podcast.com.br.podtche.api.PodApi;
import podcast.com.br.podtche.utils.ConnectionUtils;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;

/**
 * Created by fenrir on 15/03/16.
 */
public class LoginManager extends SerializedSubject<Boolean, Boolean> {

    public static final String LOGIN_PREFERENCES = "login_preferences";
    public static final String MSISDN_KEY = "msisdn";

    private static final String LOG_TAG = LoginManager.class.getSimpleName();
    private static final String MESSAGE_SUBSCRIPTION_ACTIVE = "Subscription Active!";

    private SharedPreferences preferences;
    private String msisdn;
    private boolean checkingMsisdn;
    private Context context;

    @Inject
    protected PodApi api;

    public LoginManager(Context context) {

        super(PublishSubject.<Boolean>create());

        this.context = context;

        MainApplication.getApplication(context).getComponent().inject(this);

        preferences = context.getSharedPreferences(LOGIN_PREFERENCES, Context.MODE_PRIVATE);
        msisdn = preferences.getString(MSISDN_KEY, null);
    }

    public void login(String msisdn) {
        preferences.edit().putString(MSISDN_KEY, msisdn).apply();
        this.msisdn = msisdn;
        onNext(true);
    }

    public void logout() {
        preferences.edit().remove(MSISDN_KEY).apply();
        msisdn = null;
        onNext(false);
    }

//    public void checkForNetworkMsisdn() {
//
//        if (!isLogged() && !checkingMsisdn && ConnectionUtils.isConnectedMobile(context)) {
//
//            checkingMsisdn = true;
//            new AsyncTask<String, Integer, String>() {
//                @Override
//                protected String doInBackground(String... params) {
//
//                    final OkHttpClient client = new OkHttpClient();
//                    final Request request = new Request.Builder().url(params[0]).build();
//                    try {
//                        return client.newCall(request).execute().body().string();
//                    } catch (IOException ignored) {
//                    }
//
//                    return "";
//                }
//
//                @Override
//                protected void onPostExecute(String result) {
//                    parseNetworkMsisdn(result);
//                    checkingMsisdn = false;
//                }
//            }.execute(context.getString(R.string.url_msisn_check));
//        }
//    }

    private void parseNetworkMsisdn(String body) {

        final Pattern pattern = Pattern.compile("55\\d+");
        final Matcher matcher = pattern.matcher(body);
        final boolean found = matcher.find();

        if (found) {

            String foundMsisdn = body.substring(matcher.start(), matcher.end());

//            api.getSubscriptionStatus(foundMsisdn)
//                    .subscribeOn(Schedulers.io())
//                    .map(response -> response.message)
//                    .filter(message -> message.equals(MESSAGE_SUBSCRIPTION_ACTIVE))
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe(message -> login(foundMsisdn), this::logError);
        }
    }

    public boolean isLogged() {
        return msisdn != null;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void verifySubscription() {
//        api.getSubscriptionStatus(msisdn)
//                .subscribeOn(Schedulers.io())
//                .map(response -> response.message)
//                .filter(message -> !message.equals(MESSAGE_SUBSCRIPTION_ACTIVE))
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(nonSub -> logout(), this::logError);
    }

    public boolean validate(String message) {
        return message.equals(MESSAGE_SUBSCRIPTION_ACTIVE);
    }

    private void logError(Throwable throwable) {
        Log.e(LOG_TAG, "error", throwable);
    }
}
