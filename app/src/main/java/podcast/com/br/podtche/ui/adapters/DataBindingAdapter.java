package podcast.com.br.podtche.ui.adapters;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import podcast.com.br.podtche.model.DefaultResponse;
import podcast.com.br.podtche.model.Podty;

/**
 * Created by gholz on 3/5/16.
 */
public abstract class DataBindingAdapter<T extends ViewDataBinding, I> extends RecyclerView.Adapter<BindingViewHolder<T>> {

    protected LayoutInflater inflater;
    protected List<I> items;
    protected Activity activity;

    public DataBindingAdapter(Activity activity) {
        inflater = LayoutInflater.from(activity);
        items = new ArrayList<>();
        this.activity = activity;
    }

    @Override
    public BindingViewHolder<T> onCreateViewHolder(ViewGroup parent, int viewType) {

        T binding = DataBindingUtil.inflate(inflater, getItemResource(), parent, false);

        return new BindingViewHolder<>(binding);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(List<I> items) {

        this.items.clear();
        this.items.addAll(items);

        notifyDataSetChanged();
    }

    @LayoutRes
    protected abstract int getItemResource();
}
