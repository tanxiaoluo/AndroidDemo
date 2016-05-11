package com.tanxiaoluo.androiddemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
            rootView = inflater.inflate(layoutId, container, false);
        }
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    public int getLayoutId() {
        return layoutId;
    }

    public void setLayoutId(int layoutId) {
        this.layoutId = layoutId;
    }
}
