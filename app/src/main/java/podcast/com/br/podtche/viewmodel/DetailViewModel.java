package podcast.com.br.podtche.viewmodel;

import android.content.Context;
import android.databinding.ObservableField;

import javax.inject.Inject;

import podcast.com.br.podtche.MainApplication;
import podcast.com.br.podtche.api.PodApi;
import podcast.com.br.podtche.model.Podty;
import podcast.com.br.podtche.ui.activity.MainActivity;
import podcast.com.br.podtche.view.DetailView;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by filipenunes on 31/10/16.
 */

public class DetailViewModel extends ProgressViewModel{

    private static final String LOG_TAG = DetailViewModel.class.getSimpleName();


    public ObservableField<String> photo = new ObservableField<>();
    public ObservableField<String> author = new ObservableField<>();

    protected Podty podty;
    protected Context context;
    private DetailView detailView;

    @Inject
    protected PodApi api;

    public DetailViewModel (Context context, DetailView detailView, Podty podty){
        this.podty = podty;
        this.detailView = detailView;
        this.context = context;

        MainApplication.getApplication(context)
                .getComponent().inject(this);

        displayDetail();
        refresh();
    }

    private void displayDetail(){
        photo.set(podty.thumbnail_600);
        author.set(podty.name);

        displayContent();
        notifyChange();
    }


    public void refresh() {

        api.getEpisodes(podty.id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(detailView::displayEpisodes, this::displayError, this::displayContent);

    }

    @Override
    protected String getErrorMessage(Throwable throwable) {
        return null;
    }
}
