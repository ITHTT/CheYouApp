package com.htt.framelibrary.mvp;

/**
 * Created by ithtt on 2017/1/13.
 * 基本的Presenter接口
 */

public interface IPresenter<V> {

    void attachV(V var);

    void detachV();

    V getV();

}
