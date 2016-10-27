package podcast.com.br.podtche.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by gholz on 12/2/15.
 */
public class DateUtils {

    private static final SimpleDateFormat OUTPUT_DATE_FORMAT = new SimpleDateFormat("dd/mm/yyyy", new Locale("pt-br"));

    public static String toString(Date date) {

        if (date != null) {
            return OUTPUT_DATE_FORMAT.format(date);
        }

        return "";
    }

    public static Date fromString(String date) {
        try {
            return OUTPUT_DATE_FORMAT.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
}
