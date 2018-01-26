package com.hw.cy.app.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.hw.cy.app.R;
import com.hw.cy.app.base.BaseFragment;
import com.hw.cy.app.model.ShoppingCartEntity;
import com.hw.cy.app.util.DensityUtil;
import com.hw.cy.app.view.adapter.MainCarNewsAdapter;
import com.hw.cy.app.view.adapter.UserOrderAdapter;
import com.hw.cy.app.view.widget.RecycleViewDivider;
import com.hw.cy.app.view.widget.RefreshRecyclerView;

import java.sql.Ref;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by ithtt on 2018/1/26.
 */

public class UserOrderFragment extends BaseFragment{
    @BindView(R.id.refresh_recycler_view)
    RefreshRecyclerView refreshRecyclerView;

    private List<DelegateAdapter.Adapter> adapterList;
    private DelegateAdapter adapter;


    @Override
    public int getContentLayoutId() {
        return R.layout.fragment_user_order;
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

    private void initRefreshRecyclrView() {
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(this.getActivity());
        refreshRecyclerView.setLayoutManager(layoutManager);
        final RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        viewPool.setMaxRecycledViews(UserOrderAdapter.TYPE_ORDER_GOODS, 5);
        refreshRecyclerView.getRecyclerView().setRecycledViewPool(viewPool);
        adapter = new DelegateAdapter(layoutManager, true);
        refreshRecyclerView.setAdapter(adapter);
    }

    private void addAdapters(){
        adapterList=new ArrayList<>();

        UserOrderAdapter orderAdapter=new UserOrderAdapter(getActivity(),UserOrderAdapter.TYPE_ORDER_GOODS_STORE,1);
        orderAdapter.setData("陕西安泰捷豹4S店");
        adapterList.add(orderAdapter);

        orderAdapter=new UserOrderAdapter(getActivity(),UserOrderAdapter.TYPE_ORDER_GOODS,3);
        adapterList.add(orderAdapter);

        orderAdapter=new UserOrderAdapter(getActivity(),UserOrderAdapter.TYPE_ORDER_HANDLE,1);
        adapterList.add(orderAdapter);

        for(int i=0;i<3;i++) {
            orderAdapter = new UserOrderAdapter(getActivity(), UserOrderAdapter.TYPE_ORDER_GOODS_STORE, 1);
            orderAdapter.setData("陕西安泰捷豹4S店"+(i+1));
            adapterList.add(orderAdapter);

            orderAdapter = new UserOrderAdapter(getActivity(), UserOrderAdapter.TYPE_ORDER_GOODS, 2);
            adapterList.add(orderAdapter);

            orderAdapter = new UserOrderAdapter(getActivity(), UserOrderAdapter.TYPE_ORDER_HANDLE, 1);
            adapterList.add(orderAdapter);
        }

        adapter.addAdapters(adapterList);

    }
}
