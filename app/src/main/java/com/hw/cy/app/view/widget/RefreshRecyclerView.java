package com.hw.cy.app.view.widget;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.hw.cy.app.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

/**
 * Created by ithtt on 2018/1/22.
 */

public class RefreshRecyclerView extends FrameLayout {
    private SmartRefreshLayout refreshLayout;
    private RecyclerView recyclerView;

    private OnRefreshLoadMoreListener onRefreshLoadMoreListener;
    //
    private int pageNumber=1;


    public RefreshRecyclerView(@NonNull Context context) {
        super(context);
        initView(context);
    }

    public RefreshRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public RefreshRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public RefreshRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    private void initView(Context context){
        LayoutInflater.from(context).inflate(R.layout.layout_refresh_recyclerview,this,true);
        refreshLayout=this.findViewById(R.id.refresh_layout);
        recyclerView=this.findViewById(R.id.recyclerView);

        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                if(onRefreshLoadMoreListener!=null){
                    onRefreshLoadMoreListener.onRefresh();
                }
            }
        });

        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                if(onRefreshLoadMoreListener!=null){
                    onRefreshLoadMoreListener.onLoadMore();
                }
            }
        });
    }

    public void setOnRefreshLoadMoreListener(OnRefreshLoadMoreListener onRefreshLoadMoreListener){
        this.onRefreshLoadMoreListener=onRefreshLoadMoreListener;
    }

    public void setAdapter(RecyclerView.Adapter adapter){
        recyclerView.setAdapter(adapter);
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager){
        recyclerView.setLayoutManager(layoutManager);
    }

    public void addPageNumber(){
        this.pageNumber++;
    }

    public void resetPageNumber(){
        resetPageNumber(1);
    }

    public void resetPageNumber(int page){
        this.pageNumber=page;
    }

    public void setRefreshFinish(){
        refreshLayout.finishRefresh();
    }

    public void setLoadMoreFinish(boolean canLoadMore){
        if(canLoadMore){
            refreshLayout.finishLoadmore();
        }else{
            refreshLayout.finishLoadmoreWithNoMoreData();
        }
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public SmartRefreshLayout getRefreshLayout() {
        return refreshLayout;
    }

    public interface OnRefreshLoadMoreListener{
        void onRefresh();
        void onLoadMore();
    }

}
