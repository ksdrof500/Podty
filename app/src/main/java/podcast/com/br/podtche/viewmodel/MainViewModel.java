package podcast.com.br.podtche.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;

import javax.inject.Inject;

import podcast.com.br.podtche.MainApplication;
import podcast.com.br.podtche.data.LoginManager;

/**
 * Created by fenrir on 01/05/16.
 */
public class MainViewModel extends BaseObservable {


    @Inject
    protected LoginManager loginManager;

    public MainViewModel(Context context) {
        MainApplication.getApplication(context)
                .getComponent().inject(this);
    }

    public void verify() {

        if (!loginManager.isLogged()) {
//            loginManager.checkForNetworkMsisdn();
        } else {
            loginManager.verifySubscription();
        }
    }

    public boolean isLogged() {
        return loginManager.isLogged();
    }
}
