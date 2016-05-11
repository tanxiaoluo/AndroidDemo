package com.tanxiaoluo.androiddemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orhanobut.logger.Logger;
import com.tanxiaoluo.androiddemo.annotation.Layout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by tanluo on 2016/5/10 0010.
 */
public class BaseFragment extends Fragment {

    private int layoutId = -1;

    private View rootView;


    public static BaseFragment getInstance() {
        return new BaseFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            layoutId = Layout.LayoutResolver.resolver(this.getClass(), BaseFragment.class, -1);
            if (-1 == layoutId) {
                // TODO 抛出异常
                Logger.e("please use BaseFragment subClass");
            }
            rootView = inflater.inflate(layoutId, container, false);
        }
        ButterKnife.bind(this, rootView);
        return rootView;
    }

}
