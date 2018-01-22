package com.htt.framelibrary.network;

import android.content.Context;

import com.htt.framelibrary.log.KLog;
import com.htt.framelibrary.network.cookie.CookieJarImpl;
import com.htt.framelibrary.network.cookie.store.PersistentCookieStore;

import java.io.File;
import java.net.CookieManager;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by ithtt on 2017/10/12.
 */

public class RetrofitManager {

    public static final long DEFAULT_TIMEOUT=5*60;
    public static final long DEFAULT_CACHE_SIZE=20*1024*1024;


    private static OkHttpClient okHttpClient;
    private static Retrofit retrofit;


    public static void initRetrofit(Context context,String baseUrl,String cachePath){
        //http缓存目录
        File cacheDir=new File(cachePath);
        if(!cacheDir.exists()){
           cacheDir.mkdirs();
        }

        //日志显示级别
        HttpLoggingInterceptor.Level level= HttpLoggingInterceptor.Level.BODY;
        //新建log拦截器
        HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                KLog.d("okhttp3",message);
            }
        });
        loggingInterceptor.setLevel(level);
        OkHttpClient.Builder okhttpBuilder=new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT,TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT,TimeUnit.SECONDS)
                .cache(new Cache(cacheDir,DEFAULT_CACHE_SIZE))
                .cookieJar(new CookieJarImpl(new PersistentCookieStore(context)))
                //.addInterceptor(loggingInterceptor)
                .retryOnConnectionFailure(true);

        okHttpClient=okhttpBuilder.build();

        Retrofit.Builder retrofitBuilder=new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient);
        retrofit=retrofitBuilder.build();
    }

    public static <T> T getService(Class<T> T) {
        if(retrofit==null){
            throw new RuntimeException("Retrofit is not init!");
        }
        return retrofit.create(T);
    }

    public static OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

    public static Retrofit getRetrofit() {
        return retrofit;
    }

}
