package com.hw.cy.app.view.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.BarUtils;
import com.htt.framelibrary.log.KLog;
import com.hw.cy.app.R;
import com.hw.cy.app.base.BaseFragment;
import com.hw.cy.app.util.StatusBarUtil;
import com.hw.cy.app.view.activity.CarGoodsActivity;
import com.hw.cy.app.view.activity.CarShopMarketActivity;
import com.hw.cy.app.view.activity.CarWashStoreActivity;
import com.hw.cy.app.view.adapter.MainHomeAdapter;
import com.hw.cy.app.view.widget.RefreshRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by ithtt on 2018/1/22.
 */

public class MainHomeFragment extends BaseFragment implements View.OnClickListener {
    @BindView(R.id.refresh_recyclerview)
    RefreshRecyclerView refreshRecyclerView;
    @BindView(R.id.status_bar)
    View statusBar;
    @BindView(R.id.layout_title_bar)
    LinearLayout layoutTitleBar;
    @BindView(R.id.line)
    View titleBarLine;
    @BindView(R.id.tv_address)
    TextView tvCity;
    @BindView(R.id.iv_address)
    ImageView ivAddress;

    private int scrollY = 0;


    private DelegateAdapter adapter;
    private List<DelegateAdapter.Adapter> adapterList = null;

    @Override
    public int getContentLayoutId() {
        return R.layout.fragment_main_home;
    }

    @Override
    public void initViewData(Intent intent, Bundle saved) {
        initStatusBar();
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

    private void initStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            int height = StatusBarUtil.getStatusBarHeight(getActivity());
            statusBar.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, height));
        }
    }

    private void initRefreshRecyclrView() {
        //禁止加载更多
        refreshRecyclerView.getRefreshLayout().setEnableLoadmore(false);
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(this.getActivity());
        refreshRecyclerView.setLayoutManager(layoutManager);
        final RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        viewPool.setMaxRecycledViews(MainHomeAdapter.TYPE_HOME_CAR_NEWS, 5);
        refreshRecyclerView.getRecyclerView().setRecycledViewPool(viewPool);
        adapter = new DelegateAdapter(layoutManager, true);
        refreshRecyclerView.setAdapter(adapter);

        refreshRecyclerView.getRecyclerView().addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                scrollY += dy;
                KLog.i("dy:" + dy);
                KLog.i("scrollY:" + scrollY);
                int barHeight = layoutTitleBar.getHeight();
                KLog.i("barHeight:" + barHeight);
                if (barHeight > 0) {
                    float scale = (float) scrollY / barHeight;
                    float alpha = (255 * scale);
                    KLog.i("alpha:" + alpha);
                    if (alpha > 255f) {
                        alpha = 255f;
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            StatusBarUtil.statusBarLightMode(getActivity(), true);
                        }
                    } else if (alpha <= 0f) {
                        ivAddress.clearColorFilter();
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            StatusBarUtil.statusBarLightMode(getActivity(), false);
                        }
                    }
                    layoutTitleBar.setBackgroundColor(Color.argb((int) alpha, 255, 255, 255));
                    titleBarLine.setBackgroundColor(Color.argb((int) alpha, 242, 242, 242));
                    int color = interpolateColor(Color.WHITE, Color.parseColor("#909090"), (int) alpha, 255);
                    tvCity.setTextColor(color);
                    ivAddress.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
                }
            }
        });
    }

    private void addHomeBanner() {
        MainHomeAdapter adapter = new MainHomeAdapter(MainHomeAdapter.TYPE_HOME_BANNER, 1, null);
        adapterList.add(adapter);
    }

    private void addHomeMenu() {
        MainHomeAdapter adapter = new MainHomeAdapter(MainHomeAdapter.TYPE_HOME_MENU, 1, null);
        adapter.setOnClickMenuListener(this);
        adapterList.add(adapter);
    }

    private void addHomeExtraFunction() {
        MainHomeAdapter adapter = new MainHomeAdapter(MainHomeAdapter.TYPE_HOME_EXTRA_FUNCTION, 1, null);
        adapterList.add(adapter);
    }

    private void addHomeCarStore() {
        MainHomeAdapter adapter = new MainHomeAdapter(MainHomeAdapter.TYPE_HOME_GROUP_TITLE, 1, "发现好店");
        adapterList.add(adapter);

        for (int i = 0; i < 3; i++) {
            adapter = new MainHomeAdapter(MainHomeAdapter.TYPE_HOME_CAR_STORE, 1, null);
            adapterList.add(adapter);
        }
    }

    private void addHomeCarNews() {
        MainHomeAdapter adapter = new MainHomeAdapter(MainHomeAdapter.TYPE_HOME_GROUP_TITLE, 1, "新车快讯");
        adapterList.add(adapter);

        for (int i = 0; i < 3; i++) {
            adapter = new MainHomeAdapter(MainHomeAdapter.TYPE_HOME_CAR_NEWS, 1, null);
            adapterList.add(adapter);
        }
    }

    private void addHomeData() {
        if (adapterList == null) {
            adapterList = new ArrayList<>(12);
        } else if (!adapterList.isEmpty()) {
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

    public int interpolateColor(int colorFrom, int colorTo, int posFrom, int posTo) {
        float delta = posTo - posFrom;
        int red = (int) ((Color.red(colorFrom) - Color.red(colorTo)) * delta / posTo + Color.red(colorTo));
        int green = (int) ((Color.green(colorFrom) - Color.green(colorTo)) * delta / posTo + Color.green(colorTo));
        int blue = (int) ((Color.blue(colorFrom) - Color.blue(colorTo)) * delta / posTo) + Color.blue(colorTo);
        return Color.argb(255, red, green, blue);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        KLog.i("hidden:" + hidden);
        if (!hidden) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                int barHeight = layoutTitleBar.getHeight();
                if (scrollY >= barHeight) {
                    StatusBarUtil.statusBarLightMode(this.getActivity(), true);
                } else {
                    StatusBarUtil.statusBarLightMode(this.getActivity(), false);
                }
            }
        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.layout_menu_01:
                Intent intent = new Intent(getActivity(), CarWashStoreActivity.class);
                startActivity(intent);
                break;
            case R.id.layout_menu_02:
                break;
            /***汽车超市*/
            case R.id.layout_menu_07:
                ActivityUtils.startActivity(CarGoodsActivity.class);

                break;

            default:
                break;
        }

    }
}
