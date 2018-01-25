package com.hw.cy.app.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.hw.cy.app.R;
import com.hw.cy.app.base.BaseActivity;
import com.hw.cy.app.presenter.ShoppingCartPresenter;
import com.hw.cy.app.view.adapter.CollectAdapter;
import com.hw.cy.app.view.adapter.ShoppingCartAdapter;
import com.hw.cy.app.view.widget.RefreshRecyclerView;

import butterknife.BindView;

/**
 * Created by mac on 2018/1/25.
 * <p>
 * 收藏
 */


public class CollectActivity extends BaseActivity<ShoppingCartPresenter> {
    @BindView(R.id.refresh_recyclerview)
    RefreshRecyclerView refreshRecyclerView;

    private CollectAdapter adapter = null;

    @Override
    public int getContentLayoutId() {
        return R.layout.activity_collect;
    }

    @Override
    public void initViewData(Intent intent, Bundle saved) {
        titleBar.setTitleName("商品收藏");
        titleBar.setRightMenuTextName("编辑", new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        initRefreshRecyclerView();
    }

    @Override
    public boolean isBindRxBus() {
        return false;
    }

    @Override
    public ShoppingCartPresenter newPersenter() {
        return new ShoppingCartPresenter();
    }

    private void initRefreshRecyclerView() {
        refreshRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        refreshRecyclerView.getRefreshLayout().setEnableLoadmore(false);
        adapter = new CollectAdapter();
        refreshRecyclerView.setOnRefreshLoadMoreListener(new RefreshRecyclerView.OnRefreshLoadMoreListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        adapter.setDataList(persenter.getUserShoppingCartList());
                        refreshRecyclerView.setRefreshFinish();
                    }
                }, 1000);
            }

            @Override
            public void onLoadMore() {

            }
        });


        refreshRecyclerView.setAdapter(adapter);

        refreshRecyclerView.getRefreshLayout().autoRefresh();
    }
}
