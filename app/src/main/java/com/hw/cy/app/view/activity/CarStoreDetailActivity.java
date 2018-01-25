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
import com.hw.cy.app.view.adapter.CarStoreDetailAdapter;
import com.hw.cy.app.view.adapter.MainCarStoreAdapter;
import com.hw.cy.app.view.widget.RecycleViewDivider;
import com.hw.cy.app.view.widget.RefreshRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by ithtt on 2018/1/24.
 */

public class CarStoreDetailActivity extends BaseActivity{
    @BindView(R.id.refresh_recyclerview)
    RefreshRecyclerView refreshRecyclerView;

    private List<DelegateAdapter.Adapter> adapterList;
    private DelegateAdapter delegateAdapter;


    @Override
    public int getContentLayoutId() {
        return R.layout.activity_car_store_detail;
    }

    @Override
    public void initViewData(Intent intent, Bundle saved) {
        titleBar.setTitleName("陕西安泰捷豹4S店");
        initRefreshRecyclrView();
        addAdapters();
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
        viewPool.setMaxRecycledViews(CarStoreDetailAdapter.TYPE_CAR_STORE_DETAIL_COMMENT,5);
        refreshRecyclerView.getRecyclerView().setRecycledViewPool(viewPool);
        delegateAdapter=new DelegateAdapter(layoutManager,true);
        refreshRecyclerView.setAdapter(delegateAdapter);
        refreshRecyclerView.getRecyclerView().addItemDecoration(
                new RecycleViewDivider(this,
                        LinearLayoutManager.HORIZONTAL,
                        DensityUtil.dip2px(this,0.5f),
                        getResources().getColor(R.color.colorLine)));


    }

    private void addAdapters(){
        adapterList=new ArrayList<>(8);
        CarStoreDetailAdapter adapter=new CarStoreDetailAdapter(CarStoreDetailAdapter.TYPE_CAR_STORE_DETAIL_INFO,1);
        adapterList.add(adapter);

        adapter=new CarStoreDetailAdapter(CarStoreDetailAdapter.TYPE_CAR_STORE_DETAIL_SERVICE,1);
        adapterList.add(adapter);

        adapter=new CarStoreDetailAdapter(CarStoreDetailAdapter.TYPE_CAR_STORE_DETAIL_EVALUATE,1);
        adapterList.add(adapter);

        adapter=new CarStoreDetailAdapter(CarStoreDetailAdapter.TYPE_CAR_STORE_DETAIL_COMMENT,9);
        adapterList.add(adapter);

        delegateAdapter.addAdapters(adapterList);


    }
}
