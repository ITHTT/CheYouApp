package com.hw.cy.app.view.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.hw.cy.app.R;

import java.util.ArrayList;
import java.util.List;

import com.hw.cy.app.view.adapter.interf.OnItemClickListener;

/**
 * Created by ithtt on 2018/1/23.
 */

public class CarBrandAdapter extends RecyclerView.Adapter<CarBrandAdapter.CarBrandViewHolder> {
    private List<String> dataList = null;

    private int selectedItem = 0;

    public void setOnItemClickListener(OnItemClickListener OnItemClickListener) {
        this.OnItemClickListener = OnItemClickListener;
    }

    private OnItemClickListener OnItemClickListener;

    public CarBrandAdapter() {
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_car_brand_item, parent, false);
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
            holder.selectedMark.setVisibility(View.GONE);
        }
        holder.tvCarBrandName.setText(dataList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position != selectedItem) {
                    OnItemClickListener.onAdapterItemClick(0X001, dataList.get(position));
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
        TextView tvCarBrandName;
        View selectedMark;
        FrameLayout layoutCarBandItem;

        public CarBrandViewHolder(View itemView) {
            super(itemView);
            tvCarBrandName = itemView.findViewById(R.id.tv_car_brand_name);
            selectedMark = itemView.findViewById(R.id.selected_mark);
            layoutCarBandItem = itemView.findViewById(R.id.layout_car_brand_item);
        }
    }
}
