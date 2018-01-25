package com.hw.cy.app.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.htt.framelibrary.imageloader.GlideImageLoader;
import com.hw.cy.app.R;
import com.hw.cy.app.model.ShoppingCartEntity;
import com.hw.cy.app.view.activity.ShoppingCartActivity;
import com.hw.cy.app.view.widget.AmountView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ithtt on 2018/1/24.
 */

public class ShoppingCartAdapter extends RecyclerView.Adapter<ShoppingCartAdapter.ShoppingCartViewHolder>{
    public static final int TYPE_SHOPPING_CART_STORE=0x0001;
    public static final int TYPE_SHOPPING_CART_GOOD=0x0002;

    private List<ShoppingCartEntity> dataList;

    public ShoppingCartAdapter(){
        this.dataList=new ArrayList<>(10);
    }

    public void setData(List<ShoppingCartEntity> list){
        if(list!=null&&!list.isEmpty()){
            if(!dataList.isEmpty()){
                dataList.clear();
            }
            dataList.addAll(list);
            notifyDataSetChanged();
        }
    }


    @Override
    public ShoppingCartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=null;
        if(viewType==TYPE_SHOPPING_CART_STORE){
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_shopping_cart_store_item,parent,false);
        }else if(viewType==TYPE_SHOPPING_CART_GOOD){
            view=LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_shopping_cart_good_item,parent,false);
        }
        if(view!=null){
            return new ShoppingCartViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(ShoppingCartViewHolder holder, int position) {
        int type=getItemViewType(position);
        ShoppingCartEntity info=dataList.get(position);
        if(type==TYPE_SHOPPING_CART_STORE){
            holder.tvStoreName.setText(info.getStoreName());
            holder.tvStoreMark.setText("官方直营");
        }else if(type==TYPE_SHOPPING_CART_GOOD){
            GlideImageLoader.loadImage(Glide.with(holder.itemView.getContext()),
                    info.getGoodIcon(),
                    R.color.colorLine,
                    holder.ivGoodThumb);

            holder.tvGoodName.setText(info.getGoodName());
            holder.tvGoodMoneys.setText(String.valueOf(info.getPrices()));

        }

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return dataList.get(position).getType();
    }

    public static final class ShoppingCartViewHolder extends RecyclerView.ViewHolder{
        TextView tvStoreName;
        TextView tvStoreMark;

        ImageView ivGoodSelect;
        ImageView ivGoodThumb;
        TextView tvGoodName;
        TextView tvGoodMoneys;
        AmountView amountView;

        public ShoppingCartViewHolder(View itemView) {
            super(itemView);
            tvStoreName=itemView.findViewById(R.id.tv_store_name);
            tvStoreMark=itemView.findViewById(R.id.tv_store_extra);

            ivGoodSelect=itemView.findViewById(R.id.iv_good_select);
            ivGoodThumb=itemView.findViewById(R.id.iv_good_thumb);
            tvGoodName=itemView.findViewById(R.id.tv_good_name);
            tvGoodMoneys=itemView.findViewById(R.id.tv_good_moneys);
            amountView=itemView.findViewById(R.id.amount_view);

        }
    }
}
