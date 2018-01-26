package com.hw.cy.app.view.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ActivityUtils;
import com.hw.cy.app.R;
import com.hw.cy.app.view.activity.CarGoodsActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ithtt on 2018/1/23.
 */

public class CarShopMarketAdapter extends RecyclerView.Adapter<CarShopMarketAdapter.CarBrandViewHolder> {
    private List<String> dataList = null;


    public int getSelectedItem() {
        return selectedItem;
    }


    private int selectedItem = 0;

    public CarShopMarketAdapter() {
        this.dataList = new ArrayList<>();
    }

    public void setDataList(List<String> data) {
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
    public CarBrandViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_car_type_item, parent, false);
        return new CarBrandViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CarBrandViewHolder holder, final int position) {
        if (position == selectedItem) {
            holder.layoutCarBandItem.setSelected(true);
            holder.selectedMark.setVisibility(View.VISIBLE);
            holder.tvCarBrandName.setTextColor(Color.parseColor("#3F469B"));
        } else {
            holder.layoutCarBandItem.setSelected(false);
            holder.tvCarBrandName.setTextColor(Color.parseColor("#333333"));
            holder.selectedMark.setVisibility(View.INVISIBLE);

        }
        holder.ivGoods.setImageResource(R.mipmap.adv04);
        holder.tvCarBrandName.setText(dataList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position != selectedItem) {
                    selectedItem = position;
                    notifyDataSetChanged();
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static final class CarBrandViewHolder extends RecyclerView.ViewHolder {

        ImageView ivGoods;
        TextView tvCarBrandName;
        View selectedMark;
        LinearLayout layoutCarBandItem;

        public CarBrandViewHolder(View itemView) {
            super(itemView);
            ivGoods = itemView.findViewById(R.id.iv_goods);
            tvCarBrandName = itemView.findViewById(R.id.tv_car_type);
            selectedMark = itemView.findViewById(R.id.selected_mark);
            layoutCarBandItem = itemView.findViewById(R.id.layout_car_brand_item);
        }
    }
}
