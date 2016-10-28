package podcast.com.br.podtche.ui.adapters;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import podcast.com.br.podtche.model.Category;
import podcast.com.br.podtche.ui.fragment.PodtyListFragment;


/**
 * Created by filipenunes on 9/22/16.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {

    private List<Category> categories;

    public PagerAdapter(@NonNull List<Category> categories, FragmentManager fm) {

        super(fm);

        this.categories = new ArrayList<>();
        this.categories.addAll(categories);

    }

    @Override
    public Fragment getItem(int position) {

        final Category category = categories.get(position);

        return PodtyListFragment.newInstance(category);
    }


    @Override
    public int getCount() {
        return categories.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return categories.get(position).name;

    }
}