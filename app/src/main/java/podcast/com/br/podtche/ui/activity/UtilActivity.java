package podcast.com.br.podtche.ui.activity;

import android.support.v7.app.ActionBar;
import android.view.MenuItem;

/**
 * Created by filipenunes on 21/11/16.
 */

public class UtilActivity extends CustomFontActivity {

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        setup();
    }

    private void setup() {

        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
