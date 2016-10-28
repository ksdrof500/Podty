package podcast.com.br.podtche.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import podcast.com.br.podtche.R;
import podcast.com.br.podtche.databinding.FragmentHomeBinding;
import podcast.com.br.podtche.model.Category;
import podcast.com.br.podtche.ui.adapters.PagerAdapter;


/**
 * Created by filipenunes on 9/22/16.
 */
public class HomeFragment extends Fragment {


    private FragmentHomeBinding binding;
    private PagerAdapter adapter;


    public static HomeFragment newInstance() {
        return new HomeFragment();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.menu_title_home);
//        OffersManager.getInstance().addObserver(this);
    }
//
//    @Override
//    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        super.onCreateOptionsMenu(menu, inflater);
//        inflater.inflate(R.menu.main, menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_home, container, false);

//        mNoConnectionView = view.findViewById(R.id.noConnection);
//        mNoConnectionView.findViewById(R.id.tryAgainButton).setOnClickListener(mOnClickTryAgain);

        binding = FragmentHomeBinding.bind(view);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final List<Category> categories = new ArrayList<>();
        Category category = new Category(Category.ALL, 0);
        Category category2 = new Category("MEU HOME", 1);
        categories.add(category);
        categories.add(category2);

        adapter = new PagerAdapter(categories,
                getChildFragmentManager());

        binding.offersProgress.setVisibility(View.GONE);

        binding.pager.setAdapter(adapter);
        binding.pager.setVisibility(View.VISIBLE);

        binding.tabLayout.setupWithViewPager(binding.pager);
        binding.tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        binding.tabLayout.setVisibility(View.VISIBLE);

        binding.pager.getCurrentItem();
    }

}
