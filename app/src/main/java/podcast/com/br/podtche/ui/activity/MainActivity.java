package podcast.com.br.podtche.ui.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;


import podcast.com.br.podtche.R;
import podcast.com.br.podtche.databinding.MainBinding;
import podcast.com.br.podtche.databinding.MenuHeaderBinding;
import podcast.com.br.podtche.ui.fragment.HomeFragment;
import podcast.com.br.podtche.view.MainView;
import podcast.com.br.podtche.viewmodel.MainViewModel;
import podcast.com.br.podtche.viewmodel.MenuHeaderViewModel;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, MainView {

    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private static final String KEY_CURRENT_SCREEN = "current_screen";

    private MainBinding binding;
    private MainViewModel viewModel;
    private int selectedItem;
    private int intendedScreenId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        viewModel = new MainViewModel(this);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(viewModel);

        setSupportActionBar(binding.toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, binding.drawer,
                binding.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        binding.drawer.addDrawerListener(toggle);
        toggle.syncState();
        binding.navigation.setNavigationItemSelectedListener(this);

        View header = binding.navigation.getHeaderView(0);
        MenuHeaderBinding headerBinding = MenuHeaderBinding.bind(header);
        headerBinding.setViewModel(new MenuHeaderViewModel(this, this));

        if (savedInstanceState == null) {

            binding.navigation.setCheckedItem(R.id.nav_home);
            navigateTo(R.id.nav_home);

            viewModel.verify();

        } else {
            intendedScreenId = savedInstanceState.getInt(KEY_CURRENT_SCREEN);
            resumeNavigation(binding.getRoot());
        }
    }

    @Override
    public void onBackPressed() {

        if (binding.drawer.isDrawerOpen(GravityCompat.START)) {
            binding.drawer.closeDrawer(GravityCompat.START);
        } else if (selectedItem != R.id.nav_home) {
            binding.navigation.setCheckedItem(R.id.nav_home);
            navigateTo(R.id.nav_home);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        return navigateTo(item.getItemId());
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt(KEY_CURRENT_SCREEN, intendedScreenId != -1 ? intendedScreenId : selectedItem);
    }


    @Override
    public void resumeNavigation(View view) {
        if (intendedScreenId != -1) {
            navigateTo(intendedScreenId);
            binding.navigation.setCheckedItem(intendedScreenId);
            intendedScreenId = -1;
        } else {
//            NavigationUtils.resumeNavigation(this, view);
        }
    }

    @Override
    public void closeDrawer() {
        new Handler().postDelayed(() -> binding.drawer.closeDrawer(GravityCompat.START), 200);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            resumeNavigation(binding.getRoot());
        }
    }

    public boolean navigateTo(int id) {

        if (id != selectedItem) {

            closeDrawer();

            if (id != R.id.nav_home && !viewModel.isLogged()) {
                intendedScreenId = id;
//                NavigationUtils.navigateToLoginScreen(this);
                return false;
            }

            Fragment fragment = null;
            switch (id) {
                case R.id.nav_home:
                    replace(HomeFragment.newInstance());
                    break;
//                case R.id.nav_shopping_list:
//                    fragment = ShoppingListListFragment.newInstance();
//                    break;
//                case R.id.nav_favorites:
//                    fragment = RecipesFavoriteFragment.newInstance(true);
//                    break;
//                case R.id.nav_offers:
//                    fragment = OffersFragment.newInstance();
//                    break;
//                case R.id.nav_about_app:
//                    fragment = AboutFragment.newInstance();
//                    break;
//
//                default:
//                    break;
            }

            setupToolbar(id);
            selectedItem = id;
        }

        return true;
    }

    private void setupToolbar(int id) {

        if (id == R.id.nav_home) {
            binding.appBarLayout.setBackgroundResource(android.R.color.transparent);

            disableScroll();

        } else {

            binding.toolbar.setBackgroundResource(R.color.colorPrimary);
            binding.toolbar.setLogo(null);

            enableScroll();
        }
    }



    private void enableScroll() {

        final CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) binding.content.getLayoutParams();
        params.setBehavior(new AppBarLayout.ScrollingViewBehavior());

        binding.content.requestLayout();
    }

    private void disableScroll() {

        final CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) binding.content.getLayoutParams();
        params.setBehavior(null);

        binding.content.requestLayout();
    }

    private void replace(Fragment fragment) {

        final CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) binding
                .appBarLayout.getLayoutParams();

        final AppBarLayout.Behavior behavior = (AppBarLayout.Behavior) params.getBehavior();
        if (behavior != null) {
            behavior.onNestedFling(binding.coordinator, binding.appBarLayout, null, 0, -1000, true);
        }

        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(android.R.anim.fade_in, 0)
                .replace(R.id.content, fragment).commit();
    }


}
