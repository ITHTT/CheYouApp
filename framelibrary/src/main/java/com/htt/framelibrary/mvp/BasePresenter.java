package com.htt.framelibrary.mvp;

import com.htt.framelibrary.log.KLog;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by ithtt on 2017/1/13.
 */

public class BasePresenter<V extends IView> implements IPresenter<V>{

    protected V v;
    protected boolean isDestroy=false;

    //管理RxJava的生命周期
    protected CompositeDisposable compositeDisposable=null;

    @Override
    public void attachV(V var) {
        this.v=var;
    }

    @Override
    public void detachV() {
        this.isDestroy=true;
        KLog.i("isDestroy:"+isDestroy());
        clearDisposable();
        this.v=null;
    }

    @Override
    public V getV() {
        if(this.v == null) {
            throw new IllegalStateException("v can not be null");
        } else {
            return this.v;
        }
    }

    public boolean isDestroy() {
        return isDestroy;
    }

    /**
     * 添加Disposable
     * @param disposable
     */
    public void addDisposable(Disposable disposable){
        if(compositeDisposable==null){
            compositeDisposable=new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }

    /**
     * 清空Disposable
     */
    public void clearDisposable(){
        //KLog.i("isDisposable:"+compositeDisposable.isDisposed());
        KLog.i("取消Disposable...");
        if(compositeDisposable!=null){
            compositeDisposable.dispose();
            KLog.i("after isDisposable:"+compositeDisposable.isDisposed());
            compositeDisposable=null;
        }
    }
}
