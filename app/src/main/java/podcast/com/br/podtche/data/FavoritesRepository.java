package podcast.com.br.podtche.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.SparseBooleanArray;

/**
 * Created by gholz on 3/14/16.
 */
public class FavoritesRepository {

    private static final String FAVORITES_LIST_KEY = "favorites_list";
    private static final String PREFERENCES_NAME = "favorites";

    private SharedPreferences preferences;
    private SparseBooleanArray favorites;

    public FavoritesRepository(Context context) {

        favorites = new SparseBooleanArray();
        preferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);

        String all = preferences.getString(FAVORITES_LIST_KEY, null);
        if (all != null) {
            String[] split = all.split(",");
            for (String string : split) {
                try {
                    favorites.put(Integer.valueOf(string), true);
                } catch (NumberFormatException ignored) {
                }
            }
        }
    }

    public boolean isFavorite(int id) {
        return favorites.get(id);
    }

    public void addFavorite(int id) {
        favorites.put(id, true);
        persist();
    }

    public void removeFavorite(int id) {
        favorites.delete(id);
        persist();
    }

    private void persist() {

        StringBuilder builder = new StringBuilder("");
        for (int i = 0; i < favorites.size(); i++) {
            int key = favorites.keyAt(i);
            builder.append(key);
        }

        preferences.edit().putString(FAVORITES_LIST_KEY, builder.toString()).apply();
    }
}
