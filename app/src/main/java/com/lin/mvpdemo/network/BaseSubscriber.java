package com.lin.mvpdemo.network;

import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * @author ljz.
 * @date 2017/11/17.
 * 描述：
 */

public class BaseSubscriber<T> implements Observer<T> {
    private HttpCallBack<T> mHttpCallBack;
    private int tag;
    private boolean showDialog;

    public BaseSubscriber(HttpCallBack httpCallBack, int tag, boolean showDialog) {
        this.mHttpCallBack = httpCallBack;
        this.tag = tag;
        this.showDialog = showDialog;
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {
        mHttpCallBack.onStart(tag, showDialog);
    }

    @Override
    public void onNext(@NonNull T t) {
        Log.e("-------", "onNext"+t);
        mHttpCallBack.onSuccess(tag, t);
    }

    @Override
    public void onError(@NonNull Throwable e) {
        Log.e("-------", "onError"+e);
        mHttpCallBack.onError(tag, e);
    }

    @Override
    public void onComplete() {
        Log.e("-------", "onComplete");
        mHttpCallBack.onComplete(tag, showDialog);
    }

}
