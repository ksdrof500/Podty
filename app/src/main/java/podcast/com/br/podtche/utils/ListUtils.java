package podcast.com.br.podtche.utils;

import java.util.Collection;

/**
 * Created by fenrir on 15/10/15.
 */
public class ListUtils {

    public static boolean isNotEmpty(Collection collection) {
        return collection != null && !collection.isEmpty();
    }

    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }
}
