package com.hw.cy.app.view.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hw.cy.app.R;

/**
 * Created by ithtt on 2018/1/22.
 */

public class TitleBar extends Toolbar {
    private LinearLayout layoutBack;
    private TextView tvBackTitle;
    private TextView tvTitle;
    private LinearLayout layoutRight;
    private TextView tvRightMenu;
    private View statusBar;

    public TitleBar(Context context) {
        super(context);
        addContentView(context);
    }

    public TitleBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        addContentView(context);
    }

    public TitleBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        addContentView(context);
    }

    protected void addContentView(Context context){
        setTitle("");
        hideOverflowMenu();
        View contentView= LayoutInflater.from(context).inflate(R.layout.layout_titlebar_content,null);
        ViewGroup.LayoutParams layoutParams=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        addView(contentView,layoutParams);
        layoutBack=contentView.findViewById(R.id.layout_back);
        tvBackTitle=contentView.findViewById(R.id.tv_back_title);
        tvTitle=contentView.findViewById(R.id.tv_title);
        layoutRight=contentView.findViewById(R.id.layout_right);
        tvRightMenu=contentView.findViewById(R.id.tv_right_menu);
        statusBar=contentView.findViewById(R.id.status_bar);
    }

    public void setTitleName(String title){
        tvTitle.setText(title);
    }

    public void setBackTitleName(String title){
        tvBackTitle.setText(title);
    }

    public void setOnClickBackListener(OnClickListener onClickBackListener){
        this.layoutBack.setOnClickListener(onClickBackListener);
    }

    public void setRightMenuTextName(String name,OnClickListener clickListener){
        layoutRight.setVisibility(View.VISIBLE);
        tvRightMenu.setText(name);
        layoutRight.setOnClickListener(clickListener);
    }

    public void setStatusBarHeight(int height){
        statusBar.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,height));
    }

    public void hideBack(){
        layoutBack.setVisibility(View.GONE);
    }
}
