package podcast.com.br.podtche.viewmodel;

import android.content.Context;
import android.databinding.ObservableField;

import podcast.com.br.podtche.model.Podty;
import podcast.com.br.podtche.view.DetailView;

/**
 * Created by filipenunes on 31/10/16.
 */

public class DetailViewModel extends ProgressViewModel{


    public ObservableField<String> photo = new ObservableField<>();

    protected Podty podty;
    protected Context context;
    private DetailView detailView;


    public DetailViewModel (Context context, DetailView detailView, Podty podty){
        this.podty = podty;
        this.detailView = detailView;
        this.context = context;

        displayDetail();
    }

    private void displayDetail(){
        photo.set(podty.thumbnail_600);


        displayContent();
        notifyChange();
    }

    @Override
    protected String getErrorMessage(Throwable throwable) {
        return null;
    }
}
