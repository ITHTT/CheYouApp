package com.hw.cy.app.view.fragment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.htt.framelibrary.log.KLog;
import com.hw.cy.app.R;
import com.hw.cy.app.base.BaseFragment;
import com.hw.cy.app.util.StatusBarUtil;
import com.hw.cy.app.view.adapter.CarBrandAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by ithtt on 2018/1/22.
 */

public class MainBuyCarFragment extends BaseFragment{
    @BindView(R.id.rv_car_brand)
    RecyclerView rvCarBrand;
    @BindView(R.id.rv_car_series)
    RecyclerView rvCarSeries;

    private CarBrandAdapter brandAdapter;

    @Override
    public int getContentLayoutId() {
        return R.layout.fragment_main_buycar;
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
            StatusBarUtil.statusBarLightMode(this.getActivity(), true);
        }
        titleBar.setTitleName("购车");
        titleBar.hideBack();

        rvCarBrand.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        rvCarSeries.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        brandAdapter=new CarBrandAdapter();
        rvCarBrand.setAdapter(brandAdapter);
        addCarBrandData();
    }

    public void addCarBrandData(){
        List<String> dataList=new ArrayList<>(11);
        dataList.add("全部品牌");
        dataList.add("奔驰");
        dataList.add("奥迪");
        dataList.add("宝马");
        dataList.add("日系丰田");
        dataList.add("本田");
        dataList.add("红旗");
        dataList.add("吉利");
        dataList.add("JEEP");
        dataList.add("轮胎配件");
        dataList.add("清洗美容");
        brandAdapter.setDataList(dataList);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        KLog.i("hidden:"+hidden);
        if(!hidden){
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT) {
                StatusBarUtil.statusBarLightMode(this.getActivity(), true);
            }
        }
    }
}
