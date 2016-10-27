package podcast.com.br.podtche.data;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

/**
 * Created by gholz on 5/16/16.
 */
public class AnalyticsManager {

    private Tracker tracker;

    public AnalyticsManager(Tracker tracker) {
        this.tracker = tracker;

    }

    public void trackHomeScreen() {
        trackScreen("/home");
    }

    public void trackFavorites() {
        trackScreen("/favorites");
    }

    public void trackShoppingLists() {
        trackScreen("/shopping");
    }

    public void trackOffers() {
        trackScreen("/offers");
    }

    public void trackAbout() {
        trackScreen("/about");
    }

    public void trackConfig() {
        trackScreen("/config");
    }

    public void trackInsertPin() {
        trackScreen("/login/insert_pin");
    }

    public void trackInsertMsisdn() {
        trackScreen("/login/insert_msisdn");
    }

    public void trackSearch() {
        trackScreen("/recipes/search");
    }

    public void trackShoppingListDetail(String name) {

        if (name == null) {
            trackScreen("/shopping/add");
        } else {

            String normalized = name.toLowerCase().replace(" ", "_");
            String screen = String.format("/shopping/%s", normalized);

            trackScreen(screen);
        }
    }

    public void trackRecipe(int id, String name) {
        String screen = String.format("/recipes/%d/%s", id,name);
        trackScreen(screen);
    }

    public void trackCategory(String category) {
        String screen = String.format("/recipes/%s", category);
        trackScreen(screen);
    }

    public void trackAddToFavorites(int id, String name) {
        tracker.enableAdvertisingIdCollection(true);
        tracker.send(new HitBuilders.EventBuilder()
                .setCategory("Favorites")
                .setAction("Add")
                .setLabel(String.valueOf(id)+"/"+name).build());
    }

    public void trackRemoveFromFavorites(int id, String name) {
        tracker.enableAdvertisingIdCollection(true);
        tracker.send(new HitBuilders.EventBuilder()
                .setCategory("Favorites")
                .setAction("Remove")
                .setLabel(String.valueOf(id)+"/"+name).build());
    }

    public void trackCreateShoppingList(int id, String name) {
        tracker.enableAdvertisingIdCollection(true);
        tracker.send(new HitBuilders.EventBuilder()
                .setCategory("Shopping")
                .setAction("Create")
                .setLabel(String.valueOf(id)+"/"+name).build());
    }

    public void trackSearchAction(String query) {
        tracker.enableAdvertisingIdCollection(true);
        tracker.send(new HitBuilders.EventBuilder()
                .setCategory("Recipes")
                .setAction("Search")
                .setLabel(query).build());
    }

    public void trackSharer(int id, String name) {
        tracker.enableAdvertisingIdCollection(true);
        tracker.send(new HitBuilders.EventBuilder()
                .setCategory("Sharer")
                .setLabel(String.valueOf(id)+"/"+name).build());
    }

    private void trackScreen(String screen) {
        tracker.enableAdvertisingIdCollection(true);
        tracker.setScreenName(screen);
        tracker.send(new HitBuilders.ScreenViewBuilder().build());
    }
}
