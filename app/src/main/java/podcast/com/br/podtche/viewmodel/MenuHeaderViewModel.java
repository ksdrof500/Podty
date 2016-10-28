package podcast.com.br.podtche.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.view.View;

import java.text.MessageFormat;

import javax.inject.Inject;

import podcast.com.br.podtche.MainApplication;
import podcast.com.br.podtche.data.LoginManager;
import podcast.com.br.podtche.view.MainView;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by fenrir on 15/03/16.
 */
public class MenuHeaderViewModel extends BaseObservable {

    public ObservableBoolean isLogged = new ObservableBoolean();
    public ObservableField<String> msisdn = new ObservableField<>();
    public ObservableField<String> name = new ObservableField<>();
    public ObservableField<String> avatar = new ObservableField<>();

    @Inject
    protected LoginManager loginManager;
    private MainView mainView;

    public MenuHeaderViewModel(Context context, MainView mainView) {

        this.mainView = mainView;

        MainApplication.getApplication(context)
                .getComponent().inject(this);

        onLoginStateChanged(loginManager.isLogged());

        loginManager.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onLoginStateChanged);

        name.set("teste");
        avatar.set("http://www.mundomax.com.br/blog/wp-content/uploads/2014/02/fone-philips-brasil-oneill-sho3300bz-edicao-especial.jpg");
    }

    private void onLoginStateChanged(boolean state) {

        isLogged.set(state);

        if (state) {

            String unformated = loginManager.getMsisdn();
            String formated = MessageFormat.format("({0}) {1}", unformated.substring(2, 4), unformated.substring(4));

            msisdn.set(formated);

        } else {
            msisdn.set("");
        }
    }

    public void onClickLogin(View view) {
//
//        Intent intent = new Intent(view.getContext(),
//                isLogged.get() ? ConfigurationActivity.class : LoginActivity.class);
//        view.getContext().startActivity(intent);
//
        mainView.closeDrawer();
    }
}
