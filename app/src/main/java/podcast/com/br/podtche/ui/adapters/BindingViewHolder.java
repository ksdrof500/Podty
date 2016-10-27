package podcast.com.br.podtche.ui.adapters;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

/**
 * Created by gholz on 3/5/16.
 */
public class BindingViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {

    public T binding;

    public BindingViewHolder(T binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
