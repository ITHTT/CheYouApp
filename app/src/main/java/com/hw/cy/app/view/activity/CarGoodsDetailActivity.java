package com.hw.cy.app.view.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewParent;
import android.widget.LinearLayout;

import com.hw.cy.app.R;
import com.hw.cy.app.base.BaseActivity;
import com.hw.cy.app.util.StatusBarUtil;
import com.hw.cy.app.view.adapter.ViewPagerAdapter;
import com.hw.cy.app.view.fragment.CarGoodsDetailCommentFragment;
import com.hw.cy.app.view.fragment.CarGoodsDetailFragment;
import com.hw.cy.app.view.fragment.CarGoodsDetailInfoFragment;

import butterknife.BindView;

/**
 * Created by ithtt on 2018/1/25.
 */

public class CarGoodsDetailActivity extends BaseActivity{
    @BindView(R.id.status_bar)
    View statusBar;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @Override
    public int getContentLayoutId() {
        return R.layout.activity_car_goods_detail;
    }

    @Override
    public void initViewData(Intent intent, Bundle saved) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            int height=StatusBarUtil.getStatusBarHeight(this);
            statusBar.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,height));
        }
        addFragments();
    }

    @Override
    public boolean isBindRxBus() {
        return false;
    }

    @Override
    public Object newPersenter() {
        return null;
    }

    private void addFragments(){
        ViewPagerAdapter pagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment("商品",new CarGoodsDetailFragment());
        pagerAdapter.addFragment("详情",new CarGoodsDetailInfoFragment());
        pagerAdapter.addFragment("评论",new CarGoodsDetailCommentFragment());
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOffscreenPageLimit(pagerAdapter.getCount());
        tabLayout.setupWithViewPager(viewPager);
    }
}
