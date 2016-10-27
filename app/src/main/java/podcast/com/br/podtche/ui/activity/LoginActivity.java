package podcast.com.br.podtche.ui.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import podcast.com.br.podtche.R;
import podcast.com.br.podtche.databinding.ActivityLoginBinding;

/**
 * Created by filipenunes on 27/10/16.
 */

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

    }

    public void starMain(View view) {
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        final Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
