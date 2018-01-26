package com.hw.cy.app.view.fragment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.BarUtils;
import com.htt.framelibrary.log.KLog;
import com.hw.cy.app.R;
import com.hw.cy.app.base.BaseFragment;
import com.hw.cy.app.util.StatusBarUtil;
import com.hw.cy.app.view.activity.CollectActivity;
import com.hw.cy.app.view.activity.ProfileActivity;
import com.hw.cy.app.view.activity.ShoppingCartActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by ithtt on 2018/1/22.
 */

public class MainMineFragment extends BaseFragment {
    @BindView(R.id.layout_user_profile)
    FrameLayout layoutUserProfile;
    @BindView(R.id.iv_setting)
    ImageView ivSetting;
    Unbinder unbinder;
    @BindView(R.id.ly_store_collect)
    LinearLayout lyStoreCollect;
    @BindView(R.id.ly_shop_collect)
    LinearLayout lyShopCollect;

    @Override
    public int getContentLayoutId() {
        return R.layout.fragment_main_mine;
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

    private void initView() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            StatusBarUtil.statusBarLightMode(this.getActivity(), false);
            layoutUserProfile.setPadding(0, StatusBarUtil.getStatusBarHeight(getActivity()), 0, 0);

            BarUtils.setStatusBarAlpha(getActivity(), 0);
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        KLog.i("hidden:" + hidden);
        if (!hidden) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                StatusBarUtil.statusBarLightMode(this.getActivity(), false);
            }
        }
    }

    @OnClick(R.id.layout_user_shopping_cart)
    public void onClickShoppingCart(View view) {
        Intent intent = new Intent(getActivity(), ShoppingCartActivity.class);
        startActivity(intent);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.iv_setting, R.id.ly_store_collect, R.id.ly_shop_collect})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_setting:
                ActivityUtils.startActivity(ProfileActivity.class);
                break;
            case R.id.ly_store_collect:
                ActivityUtils.startActivity(CollectActivity.class);
                break;
            case R.id.ly_shop_collect:
                ActivityUtils.startActivity(CollectActivity.class);
                break;
        }
    }
}
