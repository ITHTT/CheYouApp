package com.hw.cy.app.view.fragment;

import android.content.Intent;
import android.os.Bundle;

import com.hw.cy.app.R;
import com.hw.cy.app.base.BaseFragment;

/**
 * Created by ithtt on 2018/1/25.
 */

public class CarGoodsDetailCommentFragment extends BaseFragment{
    @Override
    public int getContentLayoutId() {
        return R.layout.fragment_car_goods_detail_comment;
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
