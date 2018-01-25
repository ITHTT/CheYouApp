package com.hw.cy.app.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.StickyLayoutHelper;
import com.hw.cy.app.R;
import com.hw.cy.app.view.widget.RecycleViewDivider;

/**
 * Created by ithtt on 2018/1/24.
 */

public class CarStoreDetailAdapter extends DelegateAdapter.Adapter<CarStoreDetailAdapter.CarStoreDetailViewHolder>{
    public static final int TYPE_CAR_STORE_DETAIL_INFO=0x0001;
    public static final int TYPE_CAR_STORE_DETAIL_SERVICE=0x0002;
    public static final int TYPE_CAR_STORE_DETAIL_EVALUATE=0x0003;
    public static final int TYPE_CAR_STORE_DETAIL_COMMENT=0x0004;

    private int viewType;
    private int viewCount;
    private Object data;

    public CarStoreDetailAdapter(int viewType,int viewCount){
        this.viewCount=viewCount;
        this.viewType=viewType;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        if(viewType==TYPE_CAR_STORE_DETAIL_EVALUATE){
            StickyLayoutHelper layoutHelper = new StickyLayoutHelper();
            return layoutHelper;
        }
        return new LinearLayoutHelper();
    }

    @Override
    public CarStoreDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=null;
        if(viewType==TYPE_CAR_STORE_DETAIL_INFO){
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_car_store_detail_info,parent,false);
        }else if(viewType==TYPE_CAR_STORE_DETAIL_SERVICE){
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_car_store_detail_service,parent,false);
        }else if(viewType==TYPE_CAR_STORE_DETAIL_EVALUATE){
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_car_store_detail_evaluate,parent,false);

        }else if(viewType==TYPE_CAR_STORE_DETAIL_COMMENT){
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_car_store_detail_user_comment,parent,false);
        }
        if(view!=null){
            return new CarStoreDetailViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(CarStoreDetailViewHolder holder, int position) {

    }

    @Override
    public int getItemViewType(int position) {
        return viewType;
    }

    @Override
    public int getItemCount() {
        return viewCount;
    }

    public static final class CarStoreDetailViewHolder extends RecyclerView.ViewHolder{

        public CarStoreDetailViewHolder(View itemView) {
            super(itemView);
        }
    }
}
