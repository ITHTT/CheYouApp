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

/**
 * Created by ithtt on 2018/1/25.
 */

public class CarGoodsDetailAdapter extends DelegateAdapter.Adapter<CarGoodsDetailAdapter.CarGoodsDetailViewHolder>{
    public static final int TYPE_CAR_GOODS_DETAIL=0x0001;
    public static final int TYPE_CAR_GOODS_DETAIL_TITLE=0x0002;
    public static final int TYPE_CAR_GOODS_DETAIL_COMMENT=0x0003;

    private int viewType;
    private int viewCount;

    public CarGoodsDetailAdapter(int viewType,int viewCount){
        this.viewType=viewType;
        this.viewCount=viewCount;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        if(viewType==TYPE_CAR_GOODS_DETAIL_TITLE){
            StickyLayoutHelper layoutHelper = new StickyLayoutHelper();
            return layoutHelper;
        }
        return new LinearLayoutHelper();
    }

    @Override
    public CarGoodsDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=null;
        if(viewType==TYPE_CAR_GOODS_DETAIL){
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_car_goods_detail_info,parent,false);
        }else if(viewType==TYPE_CAR_GOODS_DETAIL_TITLE){
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_car_goods_detail_title,parent,false);
        }else if(viewType==TYPE_CAR_GOODS_DETAIL_COMMENT){
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_car_goods_detail_comment,parent,false);
        }
        if(view!=null){
            return new CarGoodsDetailViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(CarGoodsDetailViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return viewCount;
    }

    @Override
    public int getItemViewType(int position) {
        return viewType;
    }

    public static final class CarGoodsDetailViewHolder extends RecyclerView.ViewHolder{

        public CarGoodsDetailViewHolder(View itemView) {
            super(itemView);
        }
    }
}
