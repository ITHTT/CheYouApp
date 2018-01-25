package com.hw.cy.app.view.fragment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.blankj.utilcode.util.ActivityUtils;
import com.htt.framelibrary.log.KLog;
import com.hw.cy.app.R;
import com.hw.cy.app.base.BaseFragment;
import com.hw.cy.app.util.DensityUtil;
import com.hw.cy.app.util.StatusBarUtil;
import com.hw.cy.app.view.activity.ActivityWebView;
import com.hw.cy.app.view.adapter.MainCarNewsAdapter;
import com.hw.cy.app.view.adapter.MainHomeAdapter;
import com.hw.cy.app.view.adapter.interf.OnItemClickListener;
import com.hw.cy.app.view.widget.RecycleViewDivider;
import com.hw.cy.app.view.widget.RefreshRecyclerView;

import butterknife.BindView;

/**
 * Created by ithtt on 2018/1/22.
 */

public class MainCarNewsFragment extends BaseFragment implements OnItemClickListener {
    @BindView(R.id.rv_car_news)
    RefreshRecyclerView refreshRecyclerView;

    private MainCarNewsAdapter adapter;

    @Override
    public int getContentLayoutId() {
        return R.layout.fragment_main_news;
    }

    @Override
    public void initViewData(Intent intent, Bundle saved) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            StatusBarUtil.statusBarLightMode(getActivity(), true);
        }
        titleBar.setTitleName("车讯");
        titleBar.hideBack();
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

    private void initRefreshRecyclrView() {
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(this.getActivity());
        refreshRecyclerView.setLayoutManager(layoutManager);
        final RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        viewPool.setMaxRecycledViews(0, 5);
        refreshRecyclerView.getRecyclerView().setRecycledViewPool(viewPool);
        DelegateAdapter delegateAdapter = new DelegateAdapter(layoutManager, true);
        refreshRecyclerView.setAdapter(delegateAdapter);
        refreshRecyclerView.getRecyclerView().addItemDecoration(
                new RecycleViewDivider(getActivity(),
                        LinearLayoutManager.HORIZONTAL,
                        DensityUtil.dip2px(getActivity(), 0.5f),
                        getResources().getColor(R.color.colorLine)));

        adapter = new MainCarNewsAdapter(getActivity());
        adapter.setOnItemClickListener(this);
        delegateAdapter.addAdapter(adapter);

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        KLog.i("hidden:" + hidden);
        if (!hidden) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                StatusBarUtil.statusBarLightMode(getActivity(), true);
            }
        }
    }

    @Override
    public void onAdapterItemClick(int flag, Object item) {
        ActivityUtils.startActivity(ActivityWebView.class);
    }
}
