package com.htt.framelibrary.network;

import com.htt.framelibrary.log.KLog;
import com.htt.framelibrary.mvp.BasePresenter;
import com.htt.framelibrary.network.https.ResponseCallback;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ithtt on 2017/10/12.
 * 处理Http结果的转化类
 */

public class HttpResultHandler {

    /**
     *
     * @param presenter
     * @param requestCode
     * @param response
     * @param callback
     * @param <T>
     */
    public static final <T> void handleHttpResult(final BasePresenter presenter,
                                                  final int requestCode,
                                                  Flowable<T> response,
                                                  final ResponseCallback callback) {
        Disposable disposable=response.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<T>() {
                    @Override
                    public void accept(T t) throws Exception {
                        KLog.i("isDestroy:"+presenter.isDestroy());
                        if(!presenter.isDestroy()) {
                            callback.onSuccess(requestCode, t);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if(!presenter.isDestroy()) {
                            callback.onFail(requestCode, HttpExceptionHandler.handleException(throwable));
                        }
                    }
                });
        presenter.addDisposable(disposable);
    }

    public static final <T> void handleHttpResult(final BasePresenter presenter,
                                                  final int requestCode,
                                                  Observable<T> response,
                                                  final ResponseCallback callback){
        Disposable disposable=response.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<T>() {
                    @Override
                    public void accept(T t) throws Exception {
                        KLog.i("isDestroy:"+presenter.isDestroy());
                        if(!presenter.isDestroy()) {
                            callback.onSuccess(requestCode, t);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if(!presenter.isDestroy()) {
                            callback.onFail(requestCode, HttpExceptionHandler.handleException(throwable));
                        }
                    }
                });
        presenter.addDisposable(disposable);
    }


}
