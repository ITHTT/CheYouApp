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

/**
 * Created by ithtt on 2018/1/23.
 */

public class MainCarNewsAdapter extends DelegateAdapter.Adapter<MainCarNewsAdapter.MainCarNewsViewHolder>{
    private Context context;

    public MainCarNewsAdapter(Context context){
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
    public MainCarNewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_car_news_item,parent,false);
        return new MainCarNewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainCarNewsViewHolder holder, int position) {
        GlideImageLoader.loadImage(Glide.with(context),
                "http://www.jeep.com.cn/wrangler/images/index/car_sa_c3_yd.png",
                R.color.colorLine,
                holder.ivCarNewsThumb);
        holder.tvCarNewsTitle.setText("更高级的大玩具 全新Jeep牧马人 新车解析");
        holder.tvCarNewsCreateTime.setText("3小时前");
        holder.tvCarNewsReadCount.setText("阅读量 3233");

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public static final class MainCarNewsViewHolder extends RecyclerView.ViewHolder{
        ImageView ivCarNewsThumb;
        TextView tvCarNewsTitle;
        TextView tvCarNewsCreateTime;
        TextView tvCarNewsReadCount;

        public MainCarNewsViewHolder(View itemView) {
            super(itemView);
            ivCarNewsThumb=itemView.findViewById(R.id.iv_car_news_thumb);
            tvCarNewsTitle=itemView.findViewById(R.id.tv_car_news_title);
            tvCarNewsCreateTime=itemView.findViewById(R.id.tv_car_news_create_time);
            tvCarNewsReadCount=itemView.findViewById(R.id.tv_car_news_read_count);
        }
    }
}
