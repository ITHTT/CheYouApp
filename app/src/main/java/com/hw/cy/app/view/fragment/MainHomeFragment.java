package com.hw.cy.app.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.hw.cy.app.R;
import com.hw.cy.app.base.BaseFragment;
import com.hw.cy.app.view.adapter.MainHomeAdapter;
import com.hw.cy.app.view.widget.RefreshRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by ithtt on 2018/1/22.
 */

public class MainHomeFragment extends BaseFragment{
    @BindView(R.id.refresh_recyclerview)
    RefreshRecyclerView refreshRecyclerView;

    private DelegateAdapter adapter;
    private List<DelegateAdapter.Adapter> adapterList=null;

    @Override
    public int getContentLayoutId() {
        return R.layout.fragment_main_home;
    }

    @Override
    public void initViewData(Intent intent, Bundle saved) {
        initRefreshRecyclrView();
        addHomeData();
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
        //禁止加载更多
        refreshRecyclerView.getRefreshLayout().setEnableLoadmore(false);
        VirtualLayoutManager layoutManager=new VirtualLayoutManager(this.getActivity());
        refreshRecyclerView.setLayoutManager(layoutManager);
        final RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        viewPool.setMaxRecycledViews(MainHomeAdapter.TYPE_HOME_CAR_NEWS,5);
        refreshRecyclerView.getRecyclerView().setRecycledViewPool(viewPool);
        adapter=new DelegateAdapter(layoutManager,true);
        refreshRecyclerView.setAdapter(adapter);
    }

    private void addHomeBanner(){
        MainHomeAdapter adapter=new MainHomeAdapter(MainHomeAdapter.TYPE_HOME_BANNER,1,null);
        adapterList.add(adapter);
    }

    private void addHomeMenu(){
        MainHomeAdapter adapter=new MainHomeAdapter(MainHomeAdapter.TYPE_HOME_MENU,1,null);
        adapterList.add(adapter);
    }

    private void addHomeExtraFunction(){
        MainHomeAdapter adapter=new MainHomeAdapter(MainHomeAdapter.TYPE_HOME_EXTRA_FUNCTION,1,null);
        adapterList.add(adapter);
    }

    private void addHomeCarStore(){
        MainHomeAdapter adapter=new MainHomeAdapter(MainHomeAdapter.TYPE_HOME_GROUP_TITLE,1,null);
        adapterList.add(adapter);

        for(int i=0;i<3;i++){
            adapter=new MainHomeAdapter(MainHomeAdapter.TYPE_HOME_CAR_STORE,1,null);
            adapterList.add(adapter);
        }
    }

    private void addHomeCarNews(){
        MainHomeAdapter adapter=new MainHomeAdapter(MainHomeAdapter.TYPE_HOME_GROUP_TITLE,1,null);
        adapterList.add(adapter);

        for(int i=0;i<3;i++){
            adapter=new MainHomeAdapter(MainHomeAdapter.TYPE_HOME_CAR_NEWS,1,null);
            adapterList.add(adapter);
        }
    }

    private void addHomeData(){
        if(adapterList==null){
            adapterList=new ArrayList<>(12);
        }else if(!adapterList.isEmpty()){
            adapterList.clear();
            adapter.clear();
        }
        addHomeBanner();
        addHomeMenu();
        addHomeExtraFunction();
        addHomeCarStore();
        addHomeCarNews();
        adapter.addAdapters(adapterList);
    }
}
