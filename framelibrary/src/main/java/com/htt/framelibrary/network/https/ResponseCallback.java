package com.htt.framelibrary.network.https;

import com.htt.framelibrary.network.HttpExceptionHandler;

/**
 * Created by ithtt on 2017/10/12.
 */

public interface ResponseCallback {

    <T> void onSuccess(int requestCode,T data);

    void onFail(int requestCode, HttpExceptionHandler.ResponeThrowable error);
}
