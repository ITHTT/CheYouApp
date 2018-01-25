package com.hw.cy.app.view.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.blankj.utilcode.util.BarUtils;
import com.hw.cy.app.R;
import com.hw.cy.app.base.BaseActivity;
import com.hw.cy.app.util.DensityUtil;
import com.hw.cy.app.util.StatusBarUtil;
import com.hw.cy.app.view.adapter.CarGoodsAdapter;
import com.hw.cy.app.view.adapter.MainCarStoreAdapter;
import com.hw.cy.app.view.widget.RecycleViewDivider;
import com.hw.cy.app.view.widget.RefreshRecyclerView;

import java.sql.Ref;

import butterknife.BindView;

/**
 * Created by ithtt on 2018/1/25.
 */

public class CarGoodsActivity extends BaseActivity{
    @BindView(R.id.status_bar)
    View statusBar;
    @BindView(R.id.layout_back)
    FrameLayout layoutBack;
    @BindView(R.id.refresh_recyclerview)
    RefreshRecyclerView refreshRecyclerView;

    private CarGoodsAdapter adapter;

    @Override
    public int getContentLayoutId() {
        return R.layout.activity_car_goods_list;
    }

    @Override
    public void initViewData(Intent intent, Bundle saved) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            int height=StatusBarUtil.getStatusBarHeight(this);
            statusBar.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,height));
        }
        initRefreshRecyclrView();
    }

    @Override
    public boolean isBindRxBus() {
        return false;
    }

    @Override
    public Object newPersenter() {
        return null;
    }

    private void initRefreshRecyclrView(){
        VirtualLayoutManager layoutManager=new VirtualLayoutManager(this);
        refreshRecyclerView.setLayoutManager(layoutManager);
        final RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        viewPool.setMaxRecycledViews(0,5);
        refreshRecyclerView.getRecyclerView().setRecycledViewPool(viewPool);
        DelegateAdapter delegateAdapter=new DelegateAdapter(layoutManager,true);
        refreshRecyclerView.setAdapter(delegateAdapter);

        adapter=new CarGoodsAdapter(this);
        delegateAdapter.addAdapter(adapter);



    }
}
