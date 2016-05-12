package com.tanxiaoluo.androiddemo.ui;

import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.tanxiaoluo.androiddemo.R;
import com.tanxiaoluo.androiddemo.ui.fragment.MaterailFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.toolbar_main)
    protected Toolbar mToolbar;

    @BindView(R.id.navigation_main)
    protected NavigationView mNavigationView;

    @BindView(R.id.clayout_main)
    protected CoordinatorLayout mCoordinatorLayout;

    @BindView(R.id.main_draw_layout)
    protected DrawerLayout mDrawerLayout;

    @BindView(R.id.viewpaper_main)
    protected ViewPager mViewPager;

    @BindView(R.id.main_tablayout)
    protected TabLayout mTabLayout;

    protected ActionBar actionBar;

    protected MaterailFragment materailFragment;

    private String[] mViewPagerTitles;

    private static final String TAB_NAME_1 = "material design";

    private static final String TAB_NAME_2 = "2";

    private List<Fragment> mFragments;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        init();

        initViewPaper();
    }

    private void init() {
        // init toolBar
        setSupportActionBar(mToolbar);

        actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setTitle(R.string.material_design);
        }
        // init navigation
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item_navigition_material:
                        Snackbar.make(mCoordinatorLayout, R.string.material_design, Snackbar.LENGTH_SHORT)
                                .setAction("action", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(mContext, "Toast", Toast.LENGTH_SHORT).show();
                                    }
                                })
                                .setActionTextColor(Color.WHITE)
                                .show();
                        break;

                    default:
                        break;
                }
                return true;
            }
        });


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                mToolbar,
                R.string.navigation_drawer_open
                , R.string.navigation_drawer_close);

        mDrawerLayout.addDrawerListener(toggle);

        toggle.syncState();


    }



    private void initViewPaper() {

        mViewPagerTitles = new String[]{TAB_NAME_1, TAB_NAME_2};

        mFragments = new ArrayList<>();
        materailFragment = new MaterailFragment();
        mFragments.add(materailFragment);
        mFragments.add(new MaterailFragment());

        FragmentStatePagerAdapter mViewPagerAdapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mViewPagerTitles[position];
            }
        };


        mViewPager.setAdapter(mViewPagerAdapter);
        // 设置ViewPager最大缓存的页面个数
        mViewPager.setOffscreenPageLimit(1);

        // 给ViewPager添加页面动态监听器（为了让Toolbar中的Title可以变化相应的Tab的标题）
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //mToolbar.setTitle(mViewPagerTitles[position]);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        // 将TabLayout和ViewPager进行关联，让两者联动起来
        mTabLayout.setupWithViewPager(mViewPager);
        // 设置Tablayout的Tab显示ViewPager的适配器中的getPageTitle函数获取到的标题
        mTabLayout.setTabsFromPagerAdapter(mViewPagerAdapter);

    }
}
