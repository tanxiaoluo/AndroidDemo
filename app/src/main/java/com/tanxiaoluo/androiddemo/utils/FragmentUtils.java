package com.tanxiaoluo.androiddemo.utils;

import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.tanxiaoluo.androiddemo.ui.fragment.BaseFragment;
import com.tanxiaoluo.androiddemo.ui.fragment.MaterailFragment;

/**
 * Created by tanluo on 2016/5/10 0010.
 */
public class FragmentUtils {

    public static MaterailFragment addFragment(MaterailFragment fragment, FragmentManager manager, int contaierId) {

        FragmentTransaction transaction = manager.beginTransaction();
        if (fragment == null) {
            fragment = new MaterailFragment();
            transaction.add(contaierId, fragment);
        } else {
            transaction.show(fragment);
        }
        transaction.commit();
        return fragment;
    }

}
