package podcast.com.br.podtche.viewmodel;

import android.app.Activity;
import android.databinding.ObservableBoolean;

import com.google.firebase.analytics.FirebaseAnalytics;

import javax.inject.Inject;

import podcast.com.br.podtche.MainApplication;
import podcast.com.br.podtche.api.PodApi;
import podcast.com.br.podtche.view.HomeView;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by filipenunes on 9/28/16.
 */
public class HomeViewModel extends ProgressViewModel {

    private static final String LOG_TAG = HomeViewModel.class.getSimpleName();

    public ObservableBoolean showHighlight;

    @Inject protected PodApi api;

    private HomeView view;

    public HomeViewModel(Activity context, HomeView view) {

        this.view = view;

        MainApplication.getApplication(context)
                .getComponent().inject(this);

        FirebaseAnalytics mFirebaseAnalytics = FirebaseAnalytics.getInstance(context);
        mFirebaseAnalytics.setCurrentScreen(context,"home", "home");
        showHighlight = new ObservableBoolean();

        refresh();
    }

    public void refresh() {

        api.getPodty()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(view::displayHome, this::displayError, this::displayContent);

    }

    @Override
    protected String getErrorMessage(Throwable throwable) {
        return "Ocorreu um erro ao carregar.";
    }

//    public View.OnClickListener getOnClickDesserts() {
//        return v -> startListActivity(v.getContext(), dessertsCategory);
//    }
//
//    public View.OnClickListener getOnClickDishes() {
//        return v -> startListActivity(v.getContext(), dishesCategory);
//    }
//
//    public View.OnClickListener getOnClickDrinks() {
//        return v -> startListActivity(v.getContext(), drinksCategory);
//    }
//
//    private void startListActivity(Context context, Category category) {
//
//        Intent intent = new Intent(context, RecipesListActivity.class);
//        intent.putExtra(RecipesListActivity.EXTRA_CATEGORY, category);
//
//        context.startActivity(intent);
//    }
}