package podcast.com.br.podtche.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Created by filipenunes on 21/11/16.
 * </p>
 * <p>This class manages the app fonts creation</p>
 */

public class FontsManager {

    public static final String CUSTOM_REGULAR = Fonts.REGULAR_FONT_PATH;
    public static final String CUSTOM_BOLD = Fonts.BOLD_FONT_PATH;
    public static final String ORATOR = Fonts.ORATOR_FONT_PATH;

    private static FontsManager instance;

    private Context mContext;
    private HashMap<String, Typeface> mFonts;

    private FontsManager(Context context) {
        mContext = context;
        mFonts = new HashMap<>();
    }

    public Typeface getTypeface(String font) {
        Typeface typeface = mFonts.get(font);
        if (typeface == null) {
            typeface = Typeface.createFromAsset(mContext.getAssets(), font);
            mFonts.put(font, typeface);
        }

        return typeface;
    }

    public static FontsManager getInstance(Context context) {

        if (instance == null) {
            instance = new FontsManager(context);
        }

        return instance;
    }

    public void updateFonts(ViewGroup group, Typeface font) {
        for (int i = 0; i < group.getChildCount(); i++) {
            View view = group.getChildAt(i);
            if (view instanceof TextView) {
                TextView text = (TextView) view;
                text.setTypeface(font);
            } else if (view instanceof ViewGroup) {
                updateFonts((ViewGroup) view, font);
            }
        }
    }
}
