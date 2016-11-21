package podcast.com.br.podtche.viewmodel;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;

import javax.inject.Inject;

import podcast.com.br.podtche.MainApplication;
import podcast.com.br.podtche.model.Episodes;
import podcast.com.br.podtche.model.Podty;
import podcast.com.br.podtche.ui.activity.DetailActivity;


/**
 * Created by filipenunes on 9/28/16.
 */
public class DetailItemViewModel extends BaseObservable {

    public ObservableField<String> duration;
    public ObservableField<String> title;

    private Episodes episodes;
    private Activity activity;


    public DetailItemViewModel(Activity activity) {
        title = new ObservableField<>();
        duration = new ObservableField<>();
        this.activity = activity;

        MainApplication.getApplication(activity)
                .getComponent().inject(this);

    }

    public void bind(Episodes episodes) {
        this.episodes = episodes;

        title.set(episodes.title);
        duration.set(episodes.duration);
        notifyChange();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressWarnings("unused")
    public void onClickItem(View view) {


    }
}
