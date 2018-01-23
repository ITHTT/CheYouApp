package com.hw.cy.app.view.fragment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.hw.cy.app.R;
import com.hw.cy.app.base.BaseFragment;
import com.hw.cy.app.util.StatusBarUtil;

import butterknife.BindView;

/**
 * Created by ithtt on 2018/1/22.
 */

public class MainMineFragment extends BaseFragment{
    @BindView(R.id.layout_user_profile)
    FrameLayout layoutUserProfile;

    @Override
    public int getContentLayoutId() {
        return R.layout.fragment_main_mine;
    }

    @Override
    public void initViewData(Intent intent, Bundle saved) {
        initView();

    }

    @Override
    public boolean isBindRxBus() {
        return false;
    }

    @Override
    public Object newPersenter() {
        return null;
    }

    private void initView(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT) {
            layoutUserProfile.setPadding(0,StatusBarUtil.getStatusBarHeight(getActivity()),0,0);
        }
    }
}
