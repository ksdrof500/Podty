package podcast.com.br.podtche.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by nickbutcher on 7/29/15.
 */
public class ThreeTwoImageView extends ForegroundImageView {

    public ThreeTwoImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = View.MeasureSpec.getSize(widthMeasureSpec);
        int desiredHeight = width * 2 / 3;
        super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(desiredHeight, View.MeasureSpec.EXACTLY));
    }
}
