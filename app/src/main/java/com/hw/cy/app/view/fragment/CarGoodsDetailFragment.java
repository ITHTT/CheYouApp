package com.hw.cy.app.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.hw.cy.app.R;
import com.hw.cy.app.base.BaseFragment;
import com.hw.cy.app.view.adapter.CarGoodsDetailAdapter;
import com.hw.cy.app.view.adapter.CarStoreDetailAdapter;
import com.hw.cy.app.view.widget.RefreshRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by ithtt on 2018/1/25.
 */

public class CarGoodsDetailFragment extends BaseFragment{
    @BindView(R.id.refresh_recyclerview)
    RefreshRecyclerView refreshRecyclerView;

    private DelegateAdapter delegateAdapter;
    private List<DelegateAdapter.Adapter> adapterList;

    @Override
    public int getContentLayoutId() {
        return R.layout.fragment_car_goods_detail;
    }

    @Override
    public void initViewData(Intent intent, Bundle saved) {
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
        VirtualLayoutManager layoutManager=new VirtualLayoutManager(this.getActivity());
        refreshRecyclerView.setLayoutManager(layoutManager);
        final RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        viewPool.setMaxRecycledViews(CarGoodsDetailAdapter.TYPE_CAR_GOODS_DETAIL_COMMENT,5);
        refreshRecyclerView.getRecyclerView().setRecycledViewPool(viewPool);
        delegateAdapter=new DelegateAdapter(layoutManager,true);
        refreshRecyclerView.setAdapter(delegateAdapter);
    }

    private void addAdapters(){
        adapterList=new ArrayList<>(12);

        CarGoodsDetailAdapter adapter=new CarGoodsDetailAdapter(CarGoodsDetailAdapter.TYPE_CAR_GOODS_DETAIL,1);
        adapterList.add(adapter);

        adapter=new CarGoodsDetailAdapter(CarGoodsDetailAdapter.TYPE_CAR_GOODS_DETAIL_TITLE,1);
        adapterList.add(adapter);

        adapter=new CarGoodsDetailAdapter(CarGoodsDetailAdapter.TYPE_CAR_GOODS_DETAIL_COMMENT,10);
        adapterList.add(adapter);

        delegateAdapter.addAdapters(adapterList);

    }
}
