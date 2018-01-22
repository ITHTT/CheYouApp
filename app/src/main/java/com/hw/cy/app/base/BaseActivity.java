package com.hw.cy.app.base;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.htt.framelibrary.mvp.IPresenter;
import com.htt.framelibrary.mvp.IView;
import com.hw.cy.app.R;
import com.hw.cy.app.util.DensityUtil;
import com.hw.cy.app.util.StatusBarUtil;
import com.hw.cy.app.view.widget.TitleBar;
import com.hwangjr.rxbus.RxBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivityBase;
import me.imid.swipebacklayout.lib.app.SwipeBackActivityHelper;


/**
 * Created by ithtt on 2017/1/13.
 */

public abstract class BaseActivity<P extends IPresenter> extends AppCompatActivity implements IView<P>, SwipeBackActivityBase {
    protected Unbinder unbinder=null;
    protected P persenter;
    protected SwipeBackActivityHelper swipeBackHelper;
    protected TitleBar titleBar;
    protected boolean isDestory=false;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    @CallSuper
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTranslucentBar();
        super.onCreate(savedInstanceState);
        if(getContentLayoutId()>0){
            setContentView(getContentLayoutId());
            unbinder= ButterKnife.bind(this);
            initTitleBar();
            setEventListener();
            if(isBindRxBus()){
                RxBus.get().register(this);
            }
            if(isSwipeBack()){
                try {
                    swipeBackHelper = new SwipeBackActivityHelper(this);
                    swipeBackHelper.onActivityCreate();
                    swipeBackHelper.getSwipeBackLayout().setEdgeSize(DensityUtil.dip2px(this, 15));
                }catch (Exception e){

                }
            }
        }
        persenter=newPersenter();
        if(persenter!=null) {
            persenter.attachV(this);
        }
        initViewData(getIntent(),savedInstanceState);
    }

    protected void initTitleBar(){
        titleBar= (TitleBar) this.findViewById(R.id.toolbar);
        if(titleBar!=null){
            setSupportActionBar(titleBar);
            titleBar.setOnClickBackListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    back();
                }
            });
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                titleBar.setStatusBarHeight(StatusBarUtil.getStatusBarHeight(this));
            }
        }
    }


    protected boolean isSwipeBack(){
        return true;
    }

    protected void setTranslucentBar(){
        //透明状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            // Translucent status bar
            window.setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    protected void back(){
        this.finish();
    }

    @Override
    public void setEventListener() {

    }

    @Override
    @CallSuper
    protected void onDestroy() {
        isDestory=true;
        if(unbinder!=null){
            unbinder.unbind();
        }
        if(isBindRxBus()){
            RxBus.get().unregister(this);
        }
        if(persenter!=null){
            persenter.detachV();
            persenter=null;
        }
        super.onDestroy();
    }

    @Override
    public SwipeBackLayout getSwipeBackLayout() {
        if(swipeBackHelper!=null){
            return swipeBackHelper.getSwipeBackLayout();
        }
        return null;
    }

    @Override
    public void setSwipeBackEnable(boolean enable) {
        SwipeBackLayout swipeBackLayout=getSwipeBackLayout();
        if(swipeBackLayout!=null){
            swipeBackLayout.setEnableGesture(enable);
        }
    }

    @Override
    public void scrollToFinishActivity() {
        SwipeBackLayout swipeBackLayout=getSwipeBackLayout();
        if(swipeBackLayout!=null){
            swipeBackLayout.scrollToFinishActivity();
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if(swipeBackHelper!=null) {
            swipeBackHelper.onPostCreate();
        }
    }

    @Override
    public View findViewById(int id) {
        View v = super.findViewById(id);
        if (v == null && swipeBackHelper != null)
            return swipeBackHelper.findViewById(id);
        return v;
    }
}
