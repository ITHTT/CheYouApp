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
import com.bumptech.glide.Glide;
import com.htt.framelibrary.imageloader.GlideImageLoader;
import com.hw.cy.app.R;
import com.hw.cy.app.util.DensityUtil;
import com.willy.ratingbar.ScaleRatingBar;

import java.util.ArrayList;
import java.util.List;

import me.next.tagview.TagCloudView;

/**
 * Created by ithtt on 2018/1/23.
 */

public class MainCarStoreAdapter extends DelegateAdapter.Adapter<MainCarStoreAdapter.MainCarStoreViewHolder>{
    private Context context;

    public MainCarStoreAdapter(Context context){
        this.context=context;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        LinearLayoutHelper linearLayoutHelper=new LinearLayoutHelper();
        int dividerHeight= DensityUtil.dip2px(context,10);
        linearLayoutHelper.setMargin(dividerHeight,0,dividerHeight,0);
        return linearLayoutHelper;
    }

    @Override
    public MainCarStoreViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_car_store_item,parent,false);
        return new MainCarStoreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainCarStoreViewHolder holder, int position) {
        GlideImageLoader.loadImage(Glide.with(context),
                "https://gss1.bdstatic.com/9vo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike272%2C5%2C5%2C272%2C90/sign=64f52781e41190ef15f69a8daf72f673/574e9258d109b3de7d421304cfbf6c81810a4cd9.jpg",
                R.color.colorLine,
                holder.ivCarStoreThumb);
        holder.tvCarStroeName.setText("陕西安泰捷豹4S店");
        holder.tvCarStoreAddress.setText("雁塔区金港汽车公园路135号向北100米");
        holder.ratingBar.setRating(5f);

        List<String> tags=new ArrayList<>(3);
        tags.add("洗车");
        tags.add("保养");
        tags.add("轮胎");
        holder.tagCloudView.setTags(tags);

        holder.tvCarStoreDistance.setText("200m");

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public static final class MainCarStoreViewHolder extends RecyclerView.ViewHolder{
        ImageView ivCarStoreThumb;
        TextView tvCarStroeName;
        ScaleRatingBar ratingBar;
        TextView tvCarStoreAddress;
        TagCloudView tagCloudView;
        TextView tvCarStoreDistance;

        public MainCarStoreViewHolder(View itemView) {
            super(itemView);
            ivCarStoreThumb=itemView.findViewById(R.id.iv_car_store_thumb);
            tvCarStroeName=itemView.findViewById(R.id.tv_car_store_name);
            ratingBar=itemView.findViewById(R.id.rating_bar);
            tvCarStoreAddress=itemView.findViewById(R.id.tv_car_store_address);
            tagCloudView=itemView.findViewById(R.id.tag_cloud_view);
            tvCarStoreDistance=itemView.findViewById(R.id.tv_car_store_distance);

        }
    }
}
