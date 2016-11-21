package podcast.com.br.podtche.ui.fragment;

import android.Manifest;
import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import podcast.com.br.podtche.R;
import podcast.com.br.podtche.databinding.FragmentHomeListBinding;
import podcast.com.br.podtche.model.Category;
import podcast.com.br.podtche.model.DefaultResponse;
import podcast.com.br.podtche.model.Podty;
import podcast.com.br.podtche.ui.adapters.PodtyListAdapter;
import podcast.com.br.podtche.utils.PermissionsManager;
import podcast.com.br.podtche.utils.SimpleLocationListener;
import podcast.com.br.podtche.view.HomeView;
import podcast.com.br.podtche.viewmodel.HomeViewModel;


/**
 * Created by filipenunes on 9/22/16.
 */
public class PodtyListFragment extends Fragment implements HomeView{

    private HomeViewModel viewModel;
    private PodtyListAdapter adapter;
    private FragmentHomeListBinding binding;
    private Category category;


    public static PodtyListFragment newInstance(Category category) {

        final PodtyListFragment fragment = new PodtyListFragment();
        fragment.setCategory(category);
        fragment.setHasOptionsMenu(true);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        adapter = new PodtyListAdapter(getActivity());
        viewModel = new HomeViewModel(getActivity(), this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_home_list, container, false);
        if(category != null) {

            binding = FragmentHomeListBinding.bind(view);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), verifyScreen());
            binding.podtyList.setLayoutManager(gridLayoutManager);
            binding.podtyList.setAdapter(adapter);
            binding.setViewModel(viewModel);
            binding.podtyList.setItemAnimator(null);
//            binding.pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//                @SuppressWarnings("MissingPermission")
//                @Override
//                public void onRefresh() {
//
//
////
//                }
//
//            });

        }else{

            binding = FragmentHomeListBinding.bind(view);
            binding.podtyListCollection.setLayoutManager(new LinearLayoutManager(getContext()));
            binding.podtyListCollection.setAdapter(adapter);
            binding.podtyListCollection.setItemAnimator(null);
//            binding.pullToRefresh.setVisibility(View.GONE);
            binding.podtyListCollection.setVisibility(View.VISIBLE);

        }

        return view;

    }

    public int verifyScreen(){
        double density = getActivity().getResources().getDisplayMetrics().density;
        double width = getActivity().getResources().getDisplayMetrics().widthPixels;
        return (int) Math.floor(width / (150 * density));

    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel.refresh();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        if (adapter != null && adapter.getItemCount() > 0) {
//            binding.offersProgress.setVisibility(View.GONE);
//        }
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public void displayHome(DefaultResponse<List<Podty>> podtyList) {
        adapter.setItems(podtyList.data);
    }
}
