package com.hw.cy.app.view.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.htt.framelibrary.log.KLog;
import com.hw.cy.app.R;
import com.hw.cy.app.base.BaseActivity;
import com.hw.cy.app.util.StatusBarUtil;
import com.hw.cy.app.view.adapter.CarBrandAdapter;
import com.hw.cy.app.view.adapter.CarShopMarketAdapter;
import com.hw.cy.app.view.adapter.CarTypeAdapter;
import com.hw.cy.app.view.adapter.interf.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/1/25 0025.
 */

public class CarShopMarketActivity extends BaseActivity implements OnItemClickListener {
    @BindView(R.id.rv_car_brand)
    RecyclerView rvCarBrand;
    @BindView(R.id.rv_car_series)
    RecyclerView rvCarSeries;

    private CarBrandAdapter brandAdapter;

    private CarShopMarketAdapter typeAdapter;

    @Override
    public int getContentLayoutId() {
        return R.layout.activity_car_shop_market;
    }

    @Override
    public void initViewData(Intent intent, Bundle saved) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            StatusBarUtil.statusBarLightMode(this, true);
        }
        titleBar.setTitleName("汽车超市");
        rvCarBrand.setLayoutManager(new LinearLayoutManager(this));
        rvCarSeries.setLayoutManager(new GridLayoutManager(this, 4));

        typeAdapter = new CarShopMarketAdapter();
        brandAdapter = new CarBrandAdapter();
        brandAdapter.setOnItemClickListener(this);
        rvCarBrand.setAdapter(brandAdapter);
        rvCarSeries.setAdapter(typeAdapter);
        addCarBrandData();
    }

    @Override
    public boolean isBindRxBus() {
        return false;
    }

    @Override
    public Object newPersenter() {
        return null;
    }

    public void addCarBrandData() {
        List<String> dataList = new ArrayList<>(11);
        dataList.add("汽车饰品");
        dataList.add("汽车零件");
        dataList.add("维修保养");
        dataList.add("车载电器");
        dataList.add("美容清洗");
        dataList.add("汽车装饰");
        dataList.add("安全自驾");
        dataList.add("线下服务");
        dataList.add("轮胎配件");
        dataList.add("清洗美容");
        dataList.add("车载电器");
        dataList.add("美容清洗");
        dataList.add("汽车装饰");
        dataList.add("安全自驾");
        dataList.add("线下服务");
        dataList.add("轮胎配件");
        dataList.add("清洗美容");
        brandAdapter.setDataList(dataList);
        getData("汽车饰品");
    }


    @Override
    public void onAdapterItemClick(int flag, Object item) {
        getData(item);
    }

    private void getData(Object item) {
        List<String> data = new ArrayList<>();
        int random = new Random().nextInt(30) + 5;
        for (int i = 0; i < random; i++) {
            data.add(item.toString());
        }
        typeAdapter.setDataList(data);
    }
}
