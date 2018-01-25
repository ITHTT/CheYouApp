package com.hw.cy.app.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.blankj.utilcode.util.ActivityUtils;
import com.bumptech.glide.Glide;
import com.htt.framelibrary.imageloader.GlideImageLoader;
import com.hw.cy.app.R;
import com.hw.cy.app.util.DensityUtil;
import com.hw.cy.app.view.activity.CarGoodsDetailActivity;

/**
 * Created by ithtt on 2018/1/25.
 */

public class CarGoodsAdapter extends DelegateAdapter.Adapter<CarGoodsAdapter.CarGoodsViewHolder>{
    private Context context;

    public CarGoodsAdapter(Context context){
        this.context=context;
    }
    @Override
    public LayoutHelper onCreateLayoutHelper() {
        GridLayoutHelper gridLayoutHelper=new GridLayoutHelper(2);
        gridLayoutHelper.setAutoExpand(false);
        int dividerHeight= DensityUtil.dip2px(context,10);
        gridLayoutHelper.setVGap(dividerHeight);
        gridLayoutHelper.setHGap(dividerHeight);
        gridLayoutHelper.setMargin(dividerHeight,dividerHeight,dividerHeight,dividerHeight);
        return gridLayoutHelper;
    }

    @Override
    public CarGoodsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_car_goods_item,parent,false);
        return new CarGoodsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CarGoodsViewHolder holder, int position) {
        GlideImageLoader.loadImage(Glide.with(context),
                "https://img12.360buyimg.com/n2/jfs/t14227/138/1904944804/102214/b8ba90fa/5a67f608N759e2569.jpg",
                R.color.colorLine,
                holder.ivGoodsThumb);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityUtils.startActivity(CarGoodsDetailActivity.class);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 15;
    }

    public static final class CarGoodsViewHolder extends RecyclerView.ViewHolder{
        ImageView ivGoodsThumb;
        TextView tvGoodsName;
        TextView tvGoodsPrice;
        TextView tvGoodsEvaluation;

        public CarGoodsViewHolder(View itemView) {
            super(itemView);
            ivGoodsThumb=itemView.findViewById(R.id.iv_goods_thumb);
            tvGoodsName=itemView.findViewById(R.id.tv_goods_name);
            tvGoodsPrice=itemView.findViewById(R.id.tv_goods_price);
            tvGoodsEvaluation=itemView.findViewById(R.id.tv_goods_evaluate);

        }
    }
}
