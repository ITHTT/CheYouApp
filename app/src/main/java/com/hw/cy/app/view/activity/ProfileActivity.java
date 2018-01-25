package com.hw.cy.app.view.activity;

import android.content.Intent;
import android.os.Bundle;

import com.hw.cy.app.R;
import com.hw.cy.app.base.BaseActivity;

/**
 * Created by mac on 2018/1/25.
 */

public class ProfileActivity extends BaseActivity {
    @Override
    public int getContentLayoutId() {
        return R.layout.activity_profile;
    }

    @Override
    public void initViewData(Intent intent, Bundle saved) {
        titleBar.setTitleName("个人资料");

    }

    @Override
    public boolean isBindRxBus() {
        return false;
    }

    @Override
    public Object newPersenter() {
        return null;
    }
}
