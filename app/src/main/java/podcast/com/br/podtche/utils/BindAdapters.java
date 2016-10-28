package podcast.com.br.podtche.utils;

import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


/**
 * Created by gholz on 2/3/16.
 */
public final class BindAdapters {

    @BindingAdapter("visible")
    public static void setVisible(View view, boolean visible) {
        view.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    @BindingAdapter("hidden")
    public static void setHidden(View view, boolean hidden) {
        view.setVisibility(hidden ? View.INVISIBLE : View.VISIBLE);
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView view, String url) {
//        Glide.with(view.getContext()).load(url).crossFade().into(view);
        if (url != null && view != null) {
            try {
                Glide.with(view.getContext()).load(url)
                        .crossFade().into(view);

            }catch (Exception e){
//                SafeLog.e(LOG_TAG, url != null ? url : "URL nula");
//                MetaData metaData = new MetaData();
//                metaData.addToTab("IMAGE-URL", url,view);
//                Bugsnag.notify(e,metaData);
            }

        } else {
            view.setImageResource(android.R.color.transparent);
        }
    }

    @BindingAdapter("font")
    public static void setTypeFace(TextView view, String font) {

//        FontManager fontManager = MainApplication.getApplication(view.getContext())
//                .getComponent().getFontManager();

//        view.setTypeface(fontManager.get(font));
    }
}
