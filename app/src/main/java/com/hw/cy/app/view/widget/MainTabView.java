package com.hw.cy.app.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.StyleRes;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.hw.cy.app.R;


/**
 * Created by ithtt on 2017/10/23.
 */

public class MainTabView extends FrameLayout {
    private ImageView ivTabIcon;
    private TextView tvTabTitle;
    private TextView tvTabMsg;

    public MainTabView(@NonNull Context context) {
        super(context);
        initView(context,null);
    }

    public MainTabView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context,attrs);
    }

    public MainTabView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context,attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MainTabView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context,attrs);
    }

    private void initView(Context context, AttributeSet attrs){
        LayoutInflater.from(context).inflate(R.layout.layout_main_menu_tab,this,true);

        ivTabIcon=this.findViewById(R.id.iv_tab_icon);
        tvTabTitle=this.findViewById(R.id.tv_tab_title);
        tvTabMsg=this.findViewById(R.id.tv_tab_dot);

        if(attrs!=null){
            TypedArray arr=context.obtainStyledAttributes(attrs, R.styleable.MainTabView);
            int iconRes=arr.getResourceId(R.styleable.MainTabView_tab_icon,-1);
            if(iconRes>=0){
                ivTabIcon.setImageResource(iconRes);
            }
            String title=arr.getString(R.styleable.MainTabView_tab_name);
            if(!TextUtils.isEmpty(title)) {
                tvTabTitle.setText(title);
            }
            arr.recycle();
        }

    }

    @Override
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        tvTabTitle.setSelected(selected);
        ivTabIcon.setSelected(selected);
    }

    public void showUnReadMsg(int count) {
        tvTabMsg.setVisibility(count > 0 ? VISIBLE : GONE);
        tvTabMsg.setText(String.valueOf(count));
    }
}
