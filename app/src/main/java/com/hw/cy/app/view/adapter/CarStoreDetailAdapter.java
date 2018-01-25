package com.hw.cy.app.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.StickyLayoutHelper;
import com.hw.cy.app.R;
import com.hw.cy.app.view.widget.RecycleViewDivider;
import com.willy.ratingbar.ScaleRatingBar;
import com.youth.banner.Banner;

import me.next.tagview.TagCloudView;

/**
 * Created by ithtt on 2018/1/24.
 */

public class CarStoreDetailAdapter extends DelegateAdapter.Adapter<CarStoreDetailAdapter.CarStoreDetailViewHolder>{
    public static final int TYPE_CAR_STORE_DETAIL_INFO=0x0001;
    public static final int TYPE_CAR_STORE_DETAIL_SERVICE=0x0002;
    public static final int TYPE_CAR_STORE_DETAIL_EVALUATE=0x0003;
    public static final int TYPE_CAR_STORE_DETAIL_COMMENT=0x0004;

    private int viewType;
    private int viewCount;
    private Object data;

    public CarStoreDetailAdapter(int viewType,int viewCount){
        this.viewCount=viewCount;
        this.viewType=viewType;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        if(viewType==TYPE_CAR_STORE_DETAIL_EVALUATE){
            StickyLayoutHelper layoutHelper = new StickyLayoutHelper();
            return layoutHelper;
        }
        return new LinearLayoutHelper();
    }

    @Override
    public CarStoreDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=null;
        if(viewType==TYPE_CAR_STORE_DETAIL_INFO){
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_car_store_detail_info,parent,false);
        }else if(viewType==TYPE_CAR_STORE_DETAIL_SERVICE){
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_car_store_detail_service,parent,false);
        }else if(viewType==TYPE_CAR_STORE_DETAIL_EVALUATE){
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_car_store_detail_evaluate,parent,false);

        }else if(viewType==TYPE_CAR_STORE_DETAIL_COMMENT){
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_car_store_detail_user_comment,parent,false);
        }
        if(view!=null){
            return new CarStoreDetailViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(CarStoreDetailViewHolder holder, int position) {

    }

    @Override
    public int getItemViewType(int position) {
        return viewType;
    }

    @Override
    public int getItemCount() {
        return viewCount;
    }

    public static final class CarStoreDetailViewHolder extends RecyclerView.ViewHolder{
        Banner banner;
        TextView tvCarStoreName;
        ScaleRatingBar storeRatingBar;
        TagCloudView storeTagView;
        TextView tvCarStoreDistance;
        TextView tvCarStoreAddress;

        ListView lvStoreService;
        TextView tvStoreServiceExtra;

        TextView tvStoreEvaluate;
        ScaleRatingBar storeServiceRatingBar;
        ScaleRatingBar storeFixRatingBar;




        public CarStoreDetailViewHolder(View itemView) {
            super(itemView);
            banner=itemView.findViewById(R.id.banner);
            tvCarStoreName=itemView.findViewById(R.id.tv_car_store_name);
            storeRatingBar=itemView.findViewById(R.id.rating_bar);
            storeTagView=itemView.findViewById(R.id.tag_cloud_view);
            tvCarStoreDistance=itemView.findViewById(R.id.tv_car_store_distance);
            tvCarStoreAddress=itemView.findViewById(R.id.tv_car_store_address);

            lvStoreService=itemView.findViewById(R.id.lv_car_store_service);
            tvStoreServiceExtra=itemView.findViewById(R.id.tv_store_extra);

            tvStoreEvaluate=itemView.findViewById(R.id.tv_car_store_evaluate_value);
            storeServiceRatingBar=itemView.findViewById(R.id.service_rating_bar);
            storeFixRatingBar=itemView.findViewById(R.id.fix_rating_bar);


        }
    }
}
