package podcast.com.br.podtche.ui.activity;

import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;

import podcast.com.br.podtche.utils.CustomTypeFaceSpan;
import podcast.com.br.podtche.utils.Fonts;
import podcast.com.br.podtche.utils.FontsManager;

/**
 * Created by filipenunes on 21/11/16.
 */

public abstract class CustomFontActivity extends AppCompatActivity {

    @Override
    public void setTitle(CharSequence title) {

        Typeface font = FontsManager.getInstance(this).getTypeface(Fonts.BOLD_FONT_PATH);

        SpannableString customTitle = new SpannableString(title);
        customTitle.setSpan(new CustomTypeFaceSpan("", font), 0,
                title.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(customTitle);
        } else {
            super.setTitle(customTitle);
        }
    }
}