package podcast.com.br.podtche.viewmodel;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;

import podcast.com.br.podtche.model.Podty;
import podcast.com.br.podtche.ui.activity.DetailActivity;
import podcast.com.br.podtche.ui.activity.MainActivity;


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

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressWarnings("unused")
    public void onClickItem(View view) {
//        NavigationUtils.navigateToArticle(activity, podty, view);
        Intent intent = new Intent(activity, DetailActivity.class);
        intent.setAction(Intent.ACTION_VIEW);
//        intent.setData(Uri.parse(photoUrlBase + photo.id));
//        intent.putExtra(DetailActivity.EXTRA_AUTHOR, photo.author);
        intent.putExtra(DetailActivity.EXTRA_PODTY, podty);

        activity.startActivity(intent,
                ActivityOptions.makeSceneTransitionAnimation(activity, view,
                        view.getTransitionName()).toBundle());
    }
}
