package com.hw.cy.app.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.hw.cy.app.R;
import com.hw.cy.app.base.BaseActivity;
import com.hw.cy.app.view.adapter.ViewPagerAdapter;
import com.hw.cy.app.view.fragment.UserOrderFragment;

import butterknife.BindView;

/**
 * Created by ithtt on 2018/1/26.
 */

public class UserOrderActivity extends BaseActivity{
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @Override
    public int getContentLayoutId() {
        return R.layout.activity_user_order;
    }

    @Override
    public void initViewData(Intent intent, Bundle saved) {
        titleBar.setTitleName("我的订单");
        titleBar.setRightMenuTextName("服务订单", new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        addUserOrderFragments();

    }

    @Override
    public boolean isBindRxBus() {
        return false;
    }

    @Override
    public Object newPersenter() {
        return null;
    }

    private void addUserOrderFragments(){
        ViewPagerAdapter pagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());

        UserOrderFragment orderFragment=new UserOrderFragment();
        pagerAdapter.addFragment("全部订单",orderFragment);

        orderFragment=new UserOrderFragment();
        pagerAdapter.addFragment("待付款",orderFragment);

        orderFragment=new UserOrderFragment();
        pagerAdapter.addFragment("待收货",orderFragment);

        orderFragment=new UserOrderFragment();
        pagerAdapter.addFragment("待评价",orderFragment);

        orderFragment=new UserOrderFragment();
        pagerAdapter.addFragment("退货",orderFragment);

        viewPager.setAdapter(pagerAdapter);
        viewPager.setOffscreenPageLimit(pagerAdapter.getCount());
        tabLayout.setupWithViewPager(viewPager);

    }
}
