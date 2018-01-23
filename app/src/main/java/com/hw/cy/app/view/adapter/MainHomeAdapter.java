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
import com.gongwen.marqueen.SimpleMF;
import com.gongwen.marqueen.SimpleMarqueeView;
import com.htt.framelibrary.imageloader.GlideImageLoader;
import com.hw.cy.app.R;
import com.hw.cy.app.model.BannerImageLoader;
import com.willy.ratingbar.ScaleRatingBar;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import me.next.tagview.TagCloudView;

/**
 * Created by ithtt on 2018/1/22.
 */

public class MainHomeAdapter extends DelegateAdapter.Adapter<MainHomeAdapter.MainHomeViewHolder>{
    public static final int TYPE_HOME_BANNER=0x0001;
    public static final int TYPE_HOME_MENU=0x0002;
    public static final int TYPE_HOME_EXTRA_FUNCTION=0x0003;
    public static final int TYPE_HOME_GROUP_TITLE=0x0004;
    public static final int TYPE_HOME_CAR_STORE=0x0005;
    public static final int TYPE_HOME_CAR_NEWS=0x0006;

    private int viewType;
    private int viewCount;
    private Object data;

    public MainHomeAdapter(int viewType,int viewCount,Object data){
        this.viewType=viewType;
        this.viewCount=viewCount;
        this.data=data;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return new LinearLayoutHelper();
    }

    @Override
    public MainHomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=null;
        if(viewType==TYPE_HOME_BANNER){
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_home_banner,parent,false);
        }else if(viewType==TYPE_HOME_MENU){
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_home_menu,parent,false);
        }else if(viewType==TYPE_HOME_EXTRA_FUNCTION){
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_home_extra_function,parent,false);
        }else if(viewType==TYPE_HOME_GROUP_TITLE){
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_home_group_title,parent,false);
        }else if(viewType==TYPE_HOME_CAR_STORE){
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_home_car_store,parent,false);
        }else if(viewType==TYPE_HOME_CAR_NEWS){
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_home_car_news,parent,false);
        }
        if(view!=null){
            return new MainHomeViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(MainHomeViewHolder holder, int position) {
        if(viewType==TYPE_HOME_BANNER){
            setHomeBanner(holder);
        }else if(viewType==TYPE_HOME_GROUP_TITLE){
            setHomeGroupTitle(holder);
        }else if(viewType==TYPE_HOME_CAR_STORE){
            setHomeCarStore(holder);
        }else if(viewType==TYPE_HOME_CAR_NEWS){
            setHomeCarNews(holder);
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

    public void setHomeBanner(MainHomeViewHolder holder){
        holder.banner.setImageLoader(new BannerImageLoader());
        List<String> imgUrls=new ArrayList<>(3);
        imgUrls.add("http://img.mp.sohu.com/upload/20170730/68a3aa8dbaf741c7968eb8e9df63a696_th.png");
        imgUrls.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2468563931,2916249070&fm=27&gp=0.jpg");
        imgUrls.add("http://img.mp.sohu.com/upload/20170730/e71ad23a29e6422fb01adea98b86dc25_th.png");
        holder.banner.setImages(imgUrls);
        holder.banner.start();

        final List<String> datas = Arrays.asList("一汽-大众T-Roc量产车路试 2018年7月上市...",
                "一汽-大众T-Roc量产车路试 2018年7月上市...",
                "一汽-大众T-Roc量产车路试 2018年7月上市...");
        SimpleMF<String> marqueeFactory = new SimpleMF(holder.itemView.getContext());
        marqueeFactory.setData(datas);
        holder.tvCarNewsHot.setMarqueeFactory(marqueeFactory);
        holder.tvCarNewsHot.startFlipping();
    }

    public void setHomeGroupTitle(MainHomeViewHolder holder){
        holder.tvGroupTitle.setText((String) data);
    }

    public void setHomeCarStore(MainHomeViewHolder holder){
        GlideImageLoader.loadImage(Glide.with(holder.itemView.getContext()),
                "https://ss0.bdstatic.com/-0U0bnSm1A5BphGlnYG/tam-ogel/7cddaad029460b0d532e3a4796f2f8fd_255_96.jpg",
                R.color.colorLine,
                holder.ivCarStoreThumb);
        holder.carStoreRatingBar.setRating(5f);
        holder.tvCarStoreName.setText("陕西安泰捷豹4S店");
        holder.tvCarStoreAddress.setText("雁塔区金港汽车公园路135号向北100米");

        List<String> tags=new ArrayList<>(3);
        tags.add("洗车");
        tags.add("保养");
        tags.add("轮胎");
        holder.carStoreTag.setTags(tags);
    }

    public void setHomeCarNews(MainHomeViewHolder holder){
        holder.tvCarNewsTitle.setText("更高级的大玩具 全新Jeep牧马人新车解析");
        holder.tvCarNewsImgCount.setText("01/13");
        Context context=holder.itemView.getContext();
        GlideImageLoader.loadImage(Glide.with(context),
                "http://img3.bitautoimg.com/autoalbum/files/20171026/362/20171026182315231550136_5682026_4.jpg",
                R.color.colorLine,
                holder.ivCarNewsThumb01);
        GlideImageLoader.loadImage(Glide.with(context),
                "http://img4.bitautoimg.com/autoalbum/files/20151120/561/13502156123563_4361063_4.jpg",
                R.color.colorLine,
                holder.ivCarNewsThumb02);
        GlideImageLoader.loadImage(Glide.with(context),
                "http://img2.bitautoimg.com/autoalbum/files/20151120/504/13502150406117_4360985_4.jpg",
                R.color.colorLine,
                holder.ivCarNewsThumb03);
    }

    public static final class MainHomeViewHolder extends RecyclerView.ViewHolder{
        Banner banner;
        SimpleMarqueeView tvCarNewsHot;
        TextView tvGroupTitle;

        ImageView ivCarStoreThumb;
        TextView tvCarStoreName;
        ScaleRatingBar carStoreRatingBar;
        TextView tvCarStoreAddress;
        TagCloudView carStoreTag;

        TextView tvCarNewsTitle;
        TextView tvCarNewsImgCount;
        ImageView ivCarNewsThumb01;
        ImageView ivCarNewsThumb02;
        ImageView ivCarNewsThumb03;


        public MainHomeViewHolder(View itemView) {
            super(itemView);
            banner=itemView.findViewById(R.id.banner);
            tvCarNewsHot=itemView.findViewById(R.id.tv_car_news_hot);

            tvGroupTitle=itemView.findViewById(R.id.tv_title_name);
            ivCarStoreThumb=itemView.findViewById(R.id.iv_store_car_thumb);
            tvCarStoreName=itemView.findViewById(R.id.tv_car_store_name);
            carStoreRatingBar=itemView.findViewById(R.id.rating_bar);
            tvCarStoreAddress=itemView.findViewById(R.id.tv_car_store_address);
            carStoreTag=itemView.findViewById(R.id.tag_cloud_view);

            tvCarNewsTitle=itemView.findViewById(R.id.tv_car_news_title);
            tvCarNewsImgCount=itemView.findViewById(R.id.tv_car_news_img_count);
            ivCarNewsThumb01=itemView.findViewById(R.id.iv_car_news_thumb_01);
            ivCarNewsThumb02=itemView.findViewById(R.id.iv_car_news_thumb_02);
            ivCarNewsThumb03=itemView.findViewById(R.id.iv_car_news_thumb_03);
        }
    }
}
