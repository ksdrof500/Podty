package podcast.com.br.podtche.ui.adapters;

import android.app.Activity;

import podcast.com.br.podtche.R;
import podcast.com.br.podtche.databinding.ItemHomeBinding;
import podcast.com.br.podtche.model.Podty;
import podcast.com.br.podtche.viewmodel.HomeItemViewModel;


/**
 * Created by filipenunes on 9/22/16.
 */
public class PodtyListAdapter extends DataBindingAdapter<ItemHomeBinding, Podty> {

    private Activity activity;

    public PodtyListAdapter(Activity activity) {
        super(activity);
        this.activity = activity;
    }

//
//    @Override
//    public int getItemViewType(int position) {
//        return podtyList.get(position).image == null ? TYPE_WITHOUT_IMAGE : TYPE_WITH_IMAGE;
//    }

    @Override
    protected int getItemResource() {
        return R.layout.item_home;
    }

    @Override
    public void onBindViewHolder(BindingViewHolder<ItemHomeBinding> holder, int position) {
        if (holder.binding.getViewModel() == null) {
            holder.binding.setViewModel(new HomeItemViewModel(activity));
        }

        holder.binding.getViewModel().bind(items.get(position));

    }


//    @Override
//    public PodtyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//
//        final View view = mInflater.inflate(R.layout.item_home, parent, false);
//
//        return new PodtyViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(PodtyViewHolder holder, int position) {
//        podty = podtyList.get(position);
//        holder.bind(podtyList.get(position));
//    }

////
//    @Override
//    public int getItemCount() {
//        return podtyList.size();
//    }
//
//    public void setOffers(List<Podty> podtyList) {
//
//        this.podtyList.clear();
//        this.podtyList.addAll(podtyList);
//
//        notifyDataSetChanged();
//    }

//    public void updateFavorites() {
//
//        for (int i = 0, size = podtyList.size(); i < size; i++) {
//
//            final boolean previous = mFavoritesState.get(i);
//            final boolean current = podtyList.get(i).favorite;
//
//            if (previous != current) {
//                notifyItemChanged(i);
//                mFavoritesState.put(i, current);
//            }
//        }
//    }


//    public void setPodtyList(List<Podty> podtyList, Activity activity){
//
//        viewModels.clear();
//
//        for (Podty podty : podtyList) {
//
//            HomeItemViewModel viewModel = new HomeItemViewModel(activity);
//            viewModel.bind(podty);
//
//            viewModels.add(viewModel);
//        }
//
//        notifyDataSetChanged();
//    }

}
