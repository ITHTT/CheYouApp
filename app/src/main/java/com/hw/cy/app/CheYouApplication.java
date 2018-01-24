package com.hw.cy.app;

import android.app.Application;

import com.blankj.utilcode.util.Utils;

/**
 * Created by ithtt on 2018/1/22.
 */

public class CheYouApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }
}
