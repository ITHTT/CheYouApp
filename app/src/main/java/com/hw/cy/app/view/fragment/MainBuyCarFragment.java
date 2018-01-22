package com.hw.cy.app.view.fragment;

import android.content.Intent;
import android.os.Bundle;

import com.hw.cy.app.R;
import com.hw.cy.app.base.BaseFragment;

/**
 * Created by ithtt on 2018/1/22.
 */

public class MainBuyCarFragment extends BaseFragment{
    @Override
    public int getContentLayoutId() {
        return R.layout.fragment_main_buycar;
    }

    @Override
    public void initViewData(Intent intent, Bundle saved) {

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
