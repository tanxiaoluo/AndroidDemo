package com.tanxiaoluo.androiddemo.ui;

import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.tanxiaoluo.androiddemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.toolbar_main)
    protected Toolbar mToolbar;

    @BindView(R.id.navigation_main)
    protected NavigationView mNavigationView;

    @BindView(R.id.clayout_main)
    protected CoordinatorLayout mCoordinatorLayout;

    protected ActionBar actionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        init();
    }

    private void init() {
        setSupportActionBar(mToolbar);

        actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setTitle(R.string.material_design);
        }

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
    }
}
