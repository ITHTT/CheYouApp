package com.hw.cy.app.view.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.htt.framelibrary.imageloader.GlideImageLoader;
import com.hw.cy.app.R;
import com.hw.cy.app.model.ShoppingCartEntity;
import com.hw.cy.app.view.widget.AmountView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ithtt on 2018/1/23.
 */

public class CollectAdapter extends RecyclerView.Adapter<CollectAdapter.CollectViewHolder> {
    private List<ShoppingCartEntity> dataList;

    public int getSelectedItem() {
        return selectedItem;
    }


    private int selectedItem = 0;

    public CollectAdapter() {
        this.dataList = new ArrayList<>();
    }

    public void setDataList(List<ShoppingCartEntity> data) {
        if (data != null && !data.isEmpty()) {
            if (!this.dataList.isEmpty()) {
                dataList.clear();
            }
            dataList.addAll(data);
            notifyDataSetChanged();
        }
    }

    public void clearData() {
        if (!this.dataList.isEmpty()) {
            dataList.clear();
            notifyDataSetChanged();
        }
    }

    @Override
    public CollectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_collect_item, parent, false);
        return new CollectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CollectViewHolder holder, final int position) {
        ShoppingCartEntity info = dataList.get(position);
        GlideImageLoader.loadImage(Glide.with(holder.itemView.getContext()),
                info.getGoodIcon(),
                R.color.colorLine,
                holder.ivGoodThumb);

        holder.tvGoodName.setText(info.getGoodName());
        holder.tvGoodMoneys.setText(String.valueOf(info.getPrices()));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static final class CollectViewHolder extends RecyclerView.ViewHolder {

        TextView tvStoreName;
        TextView tvStoreMark;

        ImageView ivGoodSelect;
        ImageView ivGoodThumb;
        TextView tvGoodName;
        TextView tvGoodMoneys;
        AmountView amountView;

        public CollectViewHolder(View itemView) {
            super(itemView);
            tvStoreName = itemView.findViewById(R.id.tv_store_name);
            tvStoreMark = itemView.findViewById(R.id.tv_store_extra);

            ivGoodSelect = itemView.findViewById(R.id.iv_good_select);
            ivGoodThumb = itemView.findViewById(R.id.iv_good_thumb);
            tvGoodName = itemView.findViewById(R.id.tv_good_name);
            tvGoodMoneys = itemView.findViewById(R.id.tv_good_moneys);
            amountView = itemView.findViewById(R.id.amount_view);
        }
    }
}
