package com.hw.cy.app.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.hw.cy.app.R;

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

    }

    @Override
    public int getItemCount() {
        return viewCount;
    }

    @Override
    public int getItemViewType(int position) {
        return viewType;
    }

    public static final class MainHomeViewHolder extends RecyclerView.ViewHolder{

        public MainHomeViewHolder(View itemView) {
            super(itemView);
        }
    }
}
