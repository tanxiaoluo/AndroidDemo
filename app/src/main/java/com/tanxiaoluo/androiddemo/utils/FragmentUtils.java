package com.tanxiaoluo.androiddemo.utils;

import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.tanxiaoluo.androiddemo.ui.fragment.BaseFragment;

/**
 * Created by tanluo on 2016/5/10 0010.
 */
public class FragmentUtils {

    public static BaseFragment addFragment(BaseFragment fragment, FragmentManager manager, int contaierId) {

        FragmentTransaction transaction = manager.beginTransaction();
        if (fragment == null) {
            fragment = BaseFragment.getInstance();
            transaction.add(contaierId, fragment);
        } else {
            transaction.show(fragment);
        }
        transaction.commit();
        return fragment;
    }

}
