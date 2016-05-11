package com.tanxiaoluo.androiddemo;

import android.app.Application;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

/**
 * Created by tanluo on 2016/5/11 0011.
 */
public class DemoApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Logger
                .init("Demo")               // default PRETTYLOGGER or use just init()
                .methodCount(3)            // default 2
                .hideThreadInfo()             // default shown
                .logLevel(LogLevel.NONE)  // default LogLevel.FULL
                .methodOffset(2);           // default 0
    }
}
