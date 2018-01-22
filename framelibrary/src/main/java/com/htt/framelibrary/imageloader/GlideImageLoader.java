package com.htt.framelibrary.imageloader;

import android.widget.ImageView;

import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by ithtt on 2017/10/13.
 * Glide图片加载工具
 */

public class GlideImageLoader {

    public static void loadImage(RequestManager requestManager,
                                 String url,
                                 int placeholder,
                                 int error,
                                 boolean isCenterCrop,
                                 ImageView ivImage){
        RequestOptions options=new RequestOptions();
        options.placeholder(placeholder)
                .error(error);
        if(isCenterCrop){
            options.centerCrop();
        }
        requestManager.load(url).apply(options).into(ivImage);

    }

    public static void loadImage(RequestManager requestManager,
                                 String url,
                                 int placeholder,
                                 ImageView ivImage){
        loadImage(requestManager,url,placeholder,placeholder,true,ivImage);
    }

    public static void loadBitmap(RequestManager requestManager,
                                  String url,
                                  int placeholder,
                                  int error,
                                  boolean isCenterCrop,
                                  ImageView ivImage){
        RequestOptions options=new RequestOptions();
        options.placeholder(placeholder)
                .error(error);
        if(isCenterCrop){
            options.centerCrop();
        }
        requestManager.asBitmap().load(url).apply(options).into(ivImage);
    }

    public static void loadBitmap(RequestManager requestManager,
                                 String url,
                                 int placeholder,
                                 ImageView ivImage){
        loadBitmap(requestManager,url,placeholder,placeholder,true,ivImage);
    }

}
