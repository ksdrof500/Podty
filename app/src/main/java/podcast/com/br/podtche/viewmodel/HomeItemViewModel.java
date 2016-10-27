package podcast.com.br.podtche.viewmodel;

import android.app.Activity;
import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.view.View;

import podcast.com.br.podtche.model.Podty;


/**
 * Created by filipenunes on 9/28/16.
 */
public class HomeItemViewModel extends BaseObservable {

    public ObservableField<String> title;
    public ObservableField<String> image;

    private Podty podty;
    private Activity activity;


    public HomeItemViewModel(Activity activity) {
        title = new ObservableField<>();
        image = new ObservableField<>();
        this.activity = activity;

    }

    public void bind(Podty podty) {
        this.podty = podty;

        title.set(podty.name);
        image.set(podty.thumbnail_600);
        notifyChange();
    }

    @SuppressWarnings("unused")
    public void onClickItem(View view) {
//        NavigationUtils.navigateToArticle(activity, podty, view);
    }
}
