package podcast.com.br.podtche.ui.fragment;

import android.graphics.Typeface;
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
import podcast.com.br.podtche.utils.Fonts;
import podcast.com.br.podtche.utils.FontsManager;


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
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_home, container, false);

        binding = FragmentHomeBinding.bind(view);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final List<Category> categories = new ArrayList<>();
        Category category = new Category(Category.ALL, 0);
        Category category2 = new Category(Category.MY, 1);
        categories.add(category);
        categories.add(category2);

        adapter = new PagerAdapter(categories,
                getChildFragmentManager());

        binding.offersProgress.setVisibility(View.GONE);

        binding.pager.setAdapter(adapter);
        binding.pager.setVisibility(View.VISIBLE);

        binding.tabLayout.setupWithViewPager(binding.pager);
        binding.tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        Typeface font = FontsManager.getInstance(getContext())
                .getTypeface(Fonts.REGULAR_FONT_PATH);
        FontsManager.getInstance(getContext()).updateFonts(binding.tabLayout, font);
//        binding.pager.getCurrentItem();
    }

}
