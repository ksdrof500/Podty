package podcast.com.br.podtche.ui.adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import podcast.com.br.podtche.model.Category;
import podcast.com.br.podtche.model.Podty;
import podcast.com.br.podtche.ui.fragment.PodtyListFragment;
import podcast.com.br.podtche.viewmodel.HomeItemViewModel;


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
//        final List<Podty> offers = OffersManager.getInstance().getOffers(category);

//        final List<Podty> podtyList = mock();

        return PodtyListFragment.newInstance(category);
    }
//
//    private List<Article> mock() {
//        List<Article> list = new ArrayList<>();
//        Article article = new Article();
//        Article article2 = new Article();
//        Article article3 = new Article();
//        article.id = 1;
//        article.date = "Quinta, Setembro 22, 2016";
//        article.image = "http://dqndusk8a84ol.cloudfront.net/image/e788044cb6a27f35e953e7e2e644784e.jpg?&x=600&y=356&icq=74&sig=e13a4b70280d31f2e5e4c3f7c498b8c5";
//        article.title = "Upward: Big Wave Charger Nic Lamb Is Just Getting Started";
//        list.add(article);
//
//        article2.id = 2;
//        article2.date = "Wednesday, September 21, 2016";
//        article2.image = "http://dqndusk8a84ol.cloudfront.net/image/868c3860eaf0f8ca9e7802ce03221eb9.jpg?&x=600&y=356&icq=74&sig=6f501f07c8f5800f18266cf1f09afeae";
//        article2.title = "Sally Fitzgibbons' New Sydney Pro to Boost Points and Progress";
//        list.add(article2);
//
//        article3.id = 2;
//        article3.date = "Thursday, September 22, 2016";
//        article3.description = "Jeremy Flores is Europe's most accomplished pro surfer in history. The Frenchman (by way of Reunion Island) has been a staple of the Championship Tour since 2007, ";
//        article3.title = "Sleeper Alert: It's Jeremy Flores Season";
//        list.add(article3);
//        return list;
//
//    }

    @Override
    public int getCount() {
        return categories.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return categories.get(position).name;

    }
}