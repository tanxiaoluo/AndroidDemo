package com.tanxiaoluo.androiddemo.ui.fragment;

import android.os.Build;
import android.view.MotionEvent;
import android.view.View;

import com.tanxiaoluo.androiddemo.R;
import com.tanxiaoluo.androiddemo.annotation.Layout;

import butterknife.OnClick;
import butterknife.OnTouch;

/**
 * Created by tanluo on 2016/5/10 0010.
 */
@Layout(R.layout.fragment_materail)
public class MaterailFragment extends BaseFragment {


    @OnTouch(R.id.tv_elevation1)
    public boolean onElevationTouch(View v, MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                safeSetTranslation(v, 60);
                break;
            case MotionEvent.ACTION_UP:
                safeSetTranslation(v, 0);
                break;
        }
        return true;
    }

    private void safeSetTranslation(View v, float translationZ) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            v.setElevation(translationZ);
        }
    }

}
