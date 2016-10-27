package podcast.com.br.podtche.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.util.Log;

/**
 * Created by guilh on 26/02/2016.
 */
public abstract class ProgressViewModel extends BaseObservable {

    public ObservableBoolean showProgress = new ObservableBoolean(true);
    public ObservableBoolean showContent = new ObservableBoolean();
    public ObservableBoolean showError = new ObservableBoolean();
    public ObservableBoolean showEmpty = new ObservableBoolean();
    public ObservableField<String> message = new ObservableField<>();

    protected void displayContent() {
        showContent.set(true);
        showProgress.set(false);
        showEmpty.set(false);
    }

    protected void displayProgress() {
        showContent.set(false);
        showEmpty.set(false);
        showProgress.set(true);
    }

    protected void displayError(Throwable throwable) {

        showProgress.set(false);
        showEmpty.set(false);
        showError.set(true);
        message.set(getErrorMessage(throwable));

        Log.e("ProgressViewModel", "error", throwable);
    }

    protected void displayEmpty() {
        showContent.set(false);
        showProgress.set(false);
        showEmpty.set(true);
    }

    protected abstract String getErrorMessage(Throwable throwable);
}
