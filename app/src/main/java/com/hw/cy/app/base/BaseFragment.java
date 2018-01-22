package com.hw.cy.app.base;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.htt.framelibrary.mvp.IPresenter;
import com.htt.framelibrary.mvp.IView;
import com.hw.cy.app.R;
import com.hw.cy.app.util.StatusBarUtil;
import com.hw.cy.app.view.widget.TitleBar;
import com.hwangjr.rxbus.RxBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ithtt on 2017/1/13.
 */

public abstract class BaseFragment<P extends IPresenter> extends Fragment implements IView<P> {
    protected View rootView;
    protected Unbinder unbinder;
    protected P persenter;
    protected TitleBar titleBar=null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(this.rootView == null && this.getContentLayoutId() > 0) {
            this.rootView = inflater.inflate(this.getContentLayoutId(), container,false);
            unbinder= ButterKnife.bind(this,rootView);
            initTitleBar(rootView);
        }
        return this.rootView;
    }

    protected void initTitleBar(View view){
        titleBar= (TitleBar) view.findViewById(R.id.toolbar);
        if(titleBar!=null){
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT) {
                titleBar.setStatusBarHeight(StatusBarUtil.getStatusBarHeight(getActivity()));
            }
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(isBindRxBus()){
            RxBus.get().register(this);
        }
        setEventListener();
        persenter=newPersenter();
        if(persenter!=null) {
            persenter.attachV(this);
        }
        initViewData(getActivity().getIntent(),savedInstanceState);
    }

    @Override
    public void setEventListener() {

    }

    @Override
    public void onDestroyView() {
        if(rootView!=null){
            rootView=null;
        }
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
        super.onDestroyView();
    }

}
