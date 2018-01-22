package com.htt.framelibrary.mvp;

import android.content.Intent;
import android.os.Bundle;


/**
 * Created by ithtt on 2017/1/13.
 * 基本的View接口
 */

public interface IView<P> {

    int getContentLayoutId();

    void initViewData(Intent intent, Bundle saved);

    void setEventListener();

    boolean isBindRxBus();

    P newPersenter();

}
