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
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.StickyLayoutHelper;
import com.bumptech.glide.Glide;
import com.htt.framelibrary.imageloader.GlideImageLoader;
import com.htt.framelibrary.log.KLog;
import com.hw.cy.app.R;
import com.hw.cy.app.model.ShoppingCartEntity;
import com.hw.cy.app.util.DensityUtil;

/**
 * Created by ithtt on 2018/1/26.
 */

public class UserOrderAdapter extends DelegateAdapter.Adapter<UserOrderAdapter.UserOrderViewHolder>{
    public static final int TYPE_ORDER_GOODS_STORE=0x0001;
    public static final int TYPE_ORDER_GOODS=0x0002;
    public static final int TYPE_ORDER_HANDLE=0x0003;

    private Context context;
    private int viewType;
    private int viewCount;

    private Object data;

    public UserOrderAdapter(Context context,int viewType,int viewCount){
        this.context=context;
        this.viewCount=viewCount;
        this.viewType=viewType;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        if(viewType==TYPE_ORDER_GOODS_STORE){
            return new StickyLayoutHelper();
        }else {
            LinearLayoutHelper layoutHelper = new LinearLayoutHelper();
            if (viewType == TYPE_ORDER_HANDLE) {
                layoutHelper.setMarginBottom(DensityUtil.dip2px(context, 10));
            }
            return layoutHelper;
        }
    }

    @Override
    public UserOrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=null;
        if(viewType==TYPE_ORDER_GOODS_STORE){
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_user_order_store,parent,false);
        }else if(viewType==TYPE_ORDER_GOODS){
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_user_order_goods,parent,false);
        }else if(viewType==TYPE_ORDER_HANDLE){
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_user_order_handle,parent,false);
        }
        if(view!=null){
            return new UserOrderViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(UserOrderViewHolder holder, int position) {
        int viewType=getItemViewType(position);
        if(viewType==TYPE_ORDER_GOODS){
            setOrderGoods(holder);
        }else if(viewType==TYPE_ORDER_GOODS_STORE){
            setOrderGoodsStroe(holder);
        }

    }

    @Override
    public int getItemCount() {
        return viewCount;
    }

    @Override
    public int getItemViewType(int position) {
        return viewType;
    }

    public void setOrderGoods(UserOrderViewHolder holder){
        GlideImageLoader.loadImage(Glide.with(context),
                "https://img12.360buyimg.com/n2/jfs/t14227/138/1904944804/102214/b8ba90fa/5a67f608N759e2569.jpg",
                R.color.colorLine,
                holder.ivOrderGoodsThumb);
    }

    public void setOrderGoodsStroe(UserOrderViewHolder holder){
        if(data!=null){
            holder.tvStoreName.setText((String) data);
        }

    }

    public static final class UserOrderViewHolder extends RecyclerView.ViewHolder{
        ImageView ivOrderGoodsThumb;

        TextView tvStoreName;
        TextView tvStoreExtra;
        TextView tvOrderStatus;
        public UserOrderViewHolder(View itemView) {
            super(itemView);
            ivOrderGoodsThumb=itemView.findViewById(R.id.iv_order_goods_thumb);
            tvStoreName=itemView.findViewById(R.id.tv_store_name);
            tvStoreExtra=itemView.findViewById(R.id.tv_store_extra);
            tvOrderStatus=itemView.findViewById(R.id.tv_order_status);
        }
    }
}
