package podcast.com.br.podtche.ui.activity;

import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;

import podcast.com.br.podtche.R;
import podcast.com.br.podtche.databinding.DetailBinding;
import podcast.com.br.podtche.manager.MediaController;
import podcast.com.br.podtche.manager.MusicPreferance;
import podcast.com.br.podtche.model.DefaultResponse;
import podcast.com.br.podtche.model.Podty;
import podcast.com.br.podtche.model.SongDetail;
import podcast.com.br.podtche.phonemidea.DMPlayerUtility;
import podcast.com.br.podtche.ui.adapters.EpisodesListAdapter;
import podcast.com.br.podtche.ui.observablelib.ObservableScrollViewCallbacks;
import podcast.com.br.podtche.ui.observablelib.ScrollState;
import podcast.com.br.podtche.ui.slidinguppanelhelper.SlidingUpPanelLayout;
import podcast.com.br.podtche.ui.uicomponent.Slider;
import podcast.com.br.podtche.view.DetailView;
import podcast.com.br.podtche.viewmodel.DetailViewModel;

/**
 * Created by filipenunes on 31/10/16.
 */

public class DetailActivity extends UtilActivity implements DetailView, ObservableScrollViewCallbacks, Slider.OnValueChangedListener
//        NotificationManager.NotificationCenterDelegate {
{

    public static final String EXTRA_PODTY = "extra_podty";

    private boolean isExpand = false;
    private Podty podty;
    private DetailBinding binding;
    private DetailViewModel detailViewModel;
    private EpisodesListAdapter adapter;
    private int mParallaxImageHeight;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this,
                R.layout.activity_detail);

        Bundle extras = getIntent().getExtras();
        podty = extras.getParcelable(EXTRA_PODTY);

        detailViewModel = new DetailViewModel(this, this, podty);
        adapter = new EpisodesListAdapter(this);

//        RecyclerView.LayoutManager verticalManager = new LinearLayoutManager(getApplicationContext(),
//                OrientationHelper.VERTICAL, false);
//        binding.podtyList.setLayoutManager(verticalManager);
//        binding.podtyList.setAdapter(adapter);
//        binding.setViewModel(detailViewModel);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            Slide slide = new Slide(Gravity.BOTTOM);
//            slide.addTarget(binding.llGroup);
//            slide.setInterpolator(AnimationUtils.loadInterpolator(this, android.R.interpolator
//                    .linear_out_slow_in));
//            slide.setDuration(R.integer.detail_desc_slide_duration);
//            getWindow().setEnterTransition(slide);
//        }


    }

    private void initialize() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

//        mToolbarView = findViewById(R.id.toolbar);

        // Setup RecyclerView inside drawer
//        final TypedValue typedValue = new TypedValue();
//        getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true);
//        color = typedValue.data;
//
//        mToolbarView.setBackgroundColor(ScrollUtils.getColorWithAlpha(0, color));
//        mScrollView = (ObservableScrollView) findViewById(R.id.scroll);
        binding.includeSlidingPanelchildone.scroll.setScrollViewCallbacks(this);

        mParallaxImageHeight = getResources().getDimensionPixelSize(R.dimen.parallax_image_height);


//        banner = (ImageView) findViewById(R.id.banner);
//        tv_albumname = (TextView) findViewById(R.id.tv_albumname);
//        tv_title_fst = (TextView) findViewById(R.id.tv_title_frst);
//        tv_title_sec = (TextView) findViewById(R.id.tv_title_sec);
//        recycler_songslist = (ExpandableHeightListView) findViewById(R.id.recycler_allSongs);


        mAllSongsListAdapter = new AllSongsListAdapter(context);
        binding.includeSlidingPanelchildone.includeAlbumdetailsongslist.recyclerAllSongs.setAdapter();
//                recycler_songslist.setAdapter(mAllSongsListAdapter);

//        options = new DisplayImageOptions.Builder().showImageOnLoading(R.drawable.bg_default_album_art)
//                .showImageForEmptyUri(R.drawable.bg_default_album_art).showImageOnFail(R.drawable.bg_default_album_art).cacheInMemory(true)
//                .cacheOnDisk(true).considerExifParams(true).bitmapConfig(Bitmap.Config.RGB_565).build();

//        try {
//            bindfab_button = (FloatingActionButton) findViewById(R.id.fab_button);
//            fab_button.setColorFilter(color);
//            if (Build.VERSION.SDK_INT > 15) {
//                fab_button.setImageAlpha(255);
//            } else {
//                fab_button.setAlpha(255);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    private void getBundleValuse() {
        if (podty != null) {
//            id = mBundle.getLong("id");
//            tagFor = mBundle.getLong("tagfor");
//            albumname = mBundle.getString("albumname");
//            title_one = mBundle.getString("title_one");
//            title_sec = mBundle.getString("title_sec");
//        }
//
//        if (tagFor == PhoneMediaControl.SonLoadFor.Gener.ordinal()) {
//            loadGenersSongs(id);
//        } else if (tagFor == PhoneMediaControl.SonLoadFor.Album.ordinal()) {
//            loadAlbumSongs(id);
//        } else if (tagFor == PhoneMediaControl.SonLoadFor.Artis.ordinal()) {
//            loadArtisSongs(id);
//        } else {
        }

        binding.includeSlidingPanelchildone.includeAlbumdetailsongslist.tvAlbumname.setText(podty.name);
        binding.includeSlidingPanelchildone.includeAlbumdetailsongslist.tvTitleFrst.setText(podty.last_episode_at);
        binding.includeSlidingPanelchildone.includeAlbumdetailsongslist.tvAlbumname.setText(podty.total_episodes);
    }

    private void initiSlidingUpPanel() {

        binding.includeSlidingPanelChildtwo.bottomPalyLayout.audioProgressControl.setValue(0);

        binding.includeSlidingPanelChildtwo.bottomPalyLayout.audioProgressControl.setOnValueChangedListener(this);
        binding.includeSlidingPanelChildtwo.bottomPalyLayout.btnBackward.setOnClickListener(this);
        binding.includeSlidingPanelChildtwo.bottomPalyLayout.btnForward.setOnClickListener(this);
        binding.includeSlidingPanelChildtwo.bottomPalyLayout.btnToggle.setOnClickListener(this);
        binding.includeSlidingPanelChildtwo.bottomPalyLayout.btnSuffel.setOnClickListener(this);
        binding.includeSlidingPanelChildtwo.slidepanelchildtwoTopviewtwo.bottombarImgFavorite.setOnClickListener(this);

        binding.includeSlidingPanelChildtwo.slidepanelchildtwoTopviewone.bottombarPlay.Pause();
        binding.includeSlidingPanelChildtwo.bottomPalyLayout.btnPlay.Pause();

        binding.includeSlidingPanelChildtwo.slidepanelchildtwoTopviewone.getRoot().setVisibility(View.VISIBLE);
        binding.includeSlidingPanelChildtwo.slidepanelchildtwoTopviewtwo.getRoot().setVisibility(View.INVISIBLE);

        binding.includeSlidingPanelChildtwo.slidepanelchildtwoTopviewone.getRoot().setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                binding.slidingLayout.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);

            }
        });

        binding.includeSlidingPanelChildtwo.slidepanelchildtwoTopviewtwo.getRoot().setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                binding.slidingLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);

            }
        });

        binding.includeSlidingPanelChildtwo.slidepanelchildtwoTopviewone.bottombarPlay.setOnClickListener(this);
        binding.includeSlidingPanelChildtwo.bottomPalyLayout.btnPlay.setOnClickListener(this);


        binding.includeSlidingPanelChildtwo.bottomPalyLayout.btnToggle.setSelected((MusicPreferance.getRepeat(getBaseContext()) == 1) ? true : false);
        MediaController.getInstance().shuffleMusic =  binding.includeSlidingPanelChildtwo.bottomPalyLayout.btnToggle.isSelected() ? true : false;
        DMPlayerUtility.changeColorSet(getBaseContext(),
                binding.includeSlidingPanelChildtwo.bottomPalyLayout.btnToggle,
                binding.includeSlidingPanelChildtwo.bottomPalyLayout.btnToggle.isSelected());

        binding.includeSlidingPanelChildtwo.bottomPalyLayout.btnSuffel.setSelected(MusicPreferance.getShuffel(getBaseContext()) ? true : false);
        MediaController.getInstance().repeatMode = binding.includeSlidingPanelChildtwo.bottomPalyLayout.btnSuffel.isSelected() ? 1 : 0;
        DMPlayerUtility.changeColorSet(getBaseContext(),
                (ImageView) binding.includeSlidingPanelChildtwo.bottomPalyLayout.btnSuffel,
                binding.includeSlidingPanelChildtwo.bottomPalyLayout.btnSuffel.isSelected());

        binding.slidingLayout.setPanelSlideListener(new SlidingUpPanelLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {
//                Log.i(TAG, "onPanelSlide, offset " + slideOffset);

                if (slideOffset == 0.0f) {
                    isExpand = false;
                    binding.includeSlidingPanelChildtwo.slidepanelchildtwoTopviewone.getRoot().setVisibility(View.VISIBLE);
                    binding.includeSlidingPanelChildtwo.slidepanelchildtwoTopviewtwo.getRoot().setVisibility(View.INVISIBLE);
                } else if (slideOffset > 0.0f && slideOffset < 1.0f) {
                    // if (isExpand) {
                    // slidepanelchildtwo_topviewone.setAlpha(1.0f);
                    // slidepanelchildtwo_topviewtwo.setAlpha(1.0f -
                    // slideOffset);
                    // } else {
                    // slidepanelchildtwo_topviewone.setAlpha(1.0f -
                    // slideOffset);
                    // slidepanelchildtwo_topviewtwo.setAlpha(1.0f);
                    // }

                } else {
                    isExpand = true;
                    binding.includeSlidingPanelChildtwo.slidepanelchildtwoTopviewone.getRoot().setVisibility(View.INVISIBLE);
                    binding.includeSlidingPanelChildtwo.slidepanelchildtwoTopviewtwo.getRoot().setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onPanelExpanded(View panel) {
                isExpand = true;
            }

            @Override
            public void onPanelCollapsed(View panel) {
                isExpand = false;
            }

            @Override
            public void onPanelAnchored(View panel) {

            }

            @Override
            public void onPanelHidden(View panel) {
            }
        });

    }


    private void loadAlreadyPaing() {
        SongDetail mSongDetail = MediaController.getInstance().getPlayingSongDetail();
        if (mSongDetail != null) {
            loadSongsDetails(mSongDetail);
            updateTitle(false);
            MediaController.getInstance().checkIsFavorite(getBaseContext(), mSongDetail, binding.includeSlidingPanelChildtwo.slidepanelchildtwoTopviewtwo.bottombarImgFavorite);
        }
    }

    public void loadSongsDetails(SongDetail mDetail) {
        String contentURI = "content://media/external/audio/media/" + mDetail.getId() + "/albumart";
        imageLoader.displayImage(contentURI, songAlbumbg, options, animateFirstListener);
        imageLoader.displayImage(contentURI, img_bottom_slideone, options, animateFirstListener);
        imageLoader.displayImage(contentURI, img_bottom_slidetwo, options, animateFirstListener);

        txt_playesongname.setText(mDetail.getTitle());
        txt_songartistname.setText(mDetail.getArtist());
        txt_playesongname_slidetoptwo.setText(mDetail.getTitle());
        txt_songartistname_slidetoptwo.setText(mDetail.getArtist());

        if (txt_timetotal != null) {
            long duration = Long.valueOf(mDetail.getDuration());
            txt_timetotal.setText(duration != 0 ? String.format("%d:%02d", duration / 60, duration % 60) : "-:--");
        }
        updateProgress(mDetail);
    }

    private void updateTitle(boolean shutdown) {
        SongDetail mSongDetail = MediaController.getInstance().getPlayingSongDetail();
        if (mSongDetail == null && shutdown) {
            return;
        } else {
            updateProgress(mSongDetail);
            if (MediaController.getInstance().isAudioPaused()) {
                btn_playpausePanel.Pause();
                btn_playpause.Pause();
            } else {
                btn_playpausePanel.Play();
                btn_playpause.Play();
            }
            SongDetail audioInfo = MediaController.getInstance().getPlayingSongDetail();
            loadSongsDetails(audioInfo);

            if (txt_timetotal != null) {
                long duration = Long.valueOf(audioInfo.getDuration());
                txt_timetotal.setText(duration != 0 ? String.format("%d:%02d", duration / 60, duration % 60) : "-:--");
            }
        }
    }


    public void addObserver() {
        TAG_Observer = MediaController.getInstance().generateObserverTag();
        NotificationManager.getInstance().addObserver(this, NotificationManager.audioDidReset);
        NotificationManager.getInstance().addObserver(this, NotificationManager.audioPlayStateChanged);
        NotificationManager.getInstance().addObserver(this, NotificationManager.audioDidStarted);
        NotificationManager.getInstance().addObserver(this, NotificationManager.audioProgressDidChanged);
        NotificationManager.getInstance().addObserver(this, NotificationManager.newaudioloaded);
    }

    public void removeObserver() {
        NotificationManager.getInstance().removeObserver(this, NotificationManager.audioDidReset);
        NotificationManager.getInstance().removeObserver(this, NotificationManager.audioPlayStateChanged);
        NotificationManager.getInstance().removeObserver(this, NotificationManager.audioDidStarted);
        NotificationManager.getInstance().removeObserver(this, NotificationManager.audioProgressDidChanged);
        NotificationManager.getInstance().removeObserver(this, NotificationManager.newaudioloaded);
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
    public void onResume() {
        super.onResume();
        detailViewModel.refresh();
    }


    @Override
    public void displayEpisodes(DefaultResponse<Podty> episodes) {
        adapter.setItems(episodes.data.episodes);
    }

    private void fabanim() {
        ObjectAnimator anim = ObjectAnimator.ofFloat(binding.includeSlidingPanelchildone.includeAlbumdetailsongslist.fabButton, "scaleX", 0.0f, 1.0f);
        ObjectAnimator anim1 = ObjectAnimator.ofFloat(binding.includeSlidingPanelchildone.includeAlbumdetailsongslist.fabButton, "scaleY", 0.0f, 1.0f);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(binding.includeSlidingPanelchildone.includeAlbumdetailsongslist.fabButton, "alpha", 0.0f, 1.0f);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(anim, anim1, anim2);
        animatorSet.setDuration(500);
        animatorSet.start();
    }


    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {

    }

    @Override
    public void onDownMotionEvent() {

    }

    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {

    }

    @Override
    public void onValueChanged(int value) {

    }
}
