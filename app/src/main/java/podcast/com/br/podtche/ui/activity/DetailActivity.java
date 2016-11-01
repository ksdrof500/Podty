package podcast.com.br.podtche.ui.activity;

import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.view.Gravity;
import android.view.animation.AnimationUtils;

import podcast.com.br.podtche.R;
import podcast.com.br.podtche.databinding.DetailBinding;
import podcast.com.br.podtche.model.Podty;
import podcast.com.br.podtche.view.DetailView;
import podcast.com.br.podtche.viewmodel.DetailViewModel;

/**
 * Created by filipenunes on 31/10/16.
 */

public class DetailActivity extends AppCompatActivity implements DetailView{

    public static final String EXTRA_PODTY = "extra_podty";

    private Podty podty;
    private DetailBinding binding;
    private DetailViewModel detailViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this,
                R.layout.activity_detail);

        Bundle extras = getIntent().getExtras();

        podty = extras.getParcelable(EXTRA_PODTY);
        detailViewModel = new DetailViewModel(this, this, podty);



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Slide slide = new Slide(Gravity.BOTTOM);
            slide.addTarget(binding.description);
            slide.setInterpolator(AnimationUtils.loadInterpolator(this, android.R.interpolator
                    .linear_out_slow_in));
            slide.setDuration(R.integer.detail_desc_slide_duration);
            getWindow().setEnterTransition(slide);
        }

        binding.setViewModel(detailViewModel);

    }


    @Override
    public void onBackPressed() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            supportFinishAfterTransition();
        }else{
            super.onBackPressed();
        }
    }



    @Override
    public void displayDetail(Podty podty) {

    }
}
