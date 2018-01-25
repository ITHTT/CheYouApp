package com.hw.cy.app.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.hw.cy.app.R;
import com.hw.cy.app.base.BaseActivity;
import com.hw.cy.app.util.DensityUtil;
import com.hw.cy.app.view.adapter.MainCarStoreAdapter;
import com.hw.cy.app.view.widget.RecycleViewDivider;
import com.hw.cy.app.view.widget.RefreshRecyclerView;

import butterknife.BindView;

/**
 * Created by ithtt on 2018/1/24.
 */

public class CarWashStoreActivity extends BaseActivity{
    @BindView(R.id.refresh_recyclerview)
    RefreshRecyclerView refreshRecyclerView;

    private MainCarStoreAdapter adapter;

    @Override
    public int getContentLayoutId() {
        return R.layout.activity_car_wash_store;
    }

    @Override
    public void initViewData(Intent intent, Bundle saved) {
        titleBar.setTitleName("洗车");
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
        refreshRecyclerView.getRecyclerView().addItemDecoration(
                new RecycleViewDivider(this,
                        LinearLayoutManager.HORIZONTAL,
                        DensityUtil.dip2px(this,0.5f),
                        getResources().getColor(R.color.colorLine)));

        adapter=new MainCarStoreAdapter(this);
        delegateAdapter.addAdapter(adapter);

    }
}
