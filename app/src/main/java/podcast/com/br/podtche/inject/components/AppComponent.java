package podcast.com.br.podtche.inject.components;

import javax.inject.Singleton;

import dagger.Component;
import podcast.com.br.podtche.data.LoginManager;
import podcast.com.br.podtche.inject.modules.AppModule;
import podcast.com.br.podtche.inject.modules.NetworkModule;
import podcast.com.br.podtche.ui.activity.MainActivity;
import podcast.com.br.podtche.viewmodel.AuthenticationViewModel;
import podcast.com.br.podtche.viewmodel.HomeItemViewModel;
import podcast.com.br.podtche.viewmodel.HomeViewModel;
import podcast.com.br.podtche.viewmodel.MainViewModel;
import podcast.com.br.podtche.viewmodel.MenuHeaderViewModel;

/**
 * Created by gholz on 2/13/16.
 */
@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {

    void inject(HomeViewModel viewModel);

    void inject(HomeItemViewModel viewModel);
//
//    void inject(RecipeDetailViewModel viewModel);
//
//    void inject(ShoppingItemViewModel viewModel);
//
//    void inject(RecipesListViewModel adapter);
//
//    void inject(ShoppingListListViewModel viewModel);
//
//    void inject(ShoppingListDetailViewModel viewModel);
//
//    void inject(OffersViewModel viewModel);
//
//    void inject(InsertMsisdnViewModel viewModel);
//
//    void inject(SearchRecipesViewModel viewModel);
//
//    void inject(ConfigurationViewModel viewModel);
//
    void inject(AuthenticationViewModel viewModel);
//
    void inject(MenuHeaderViewModel viewModel);
//
    void inject(MainViewModel viewModel);
//
//    void inject(WrenManger manger);
//
    void inject(MainActivity activity);
//
    void inject(LoginManager loginManager);

//    FontManager getFontManager();

//    LoginManager getLoginManager();
//
//    AnalyticsManager getAnalyticsManager();

}
