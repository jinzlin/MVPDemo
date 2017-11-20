package com.lin.mvpdemo.mvp;


import com.lin.mvpdemo.network.HttpCallBack;
import com.lin.mvpdemo.network.RetrofitHelper;
import com.lin.mvpdemo.utils.JsonUtils;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author ljz.
 * @date 2017/11/15
 */

public class BasePresenter<T extends BaseContract.BaseView> implements BaseContract.BasePresenter<T> , HttpCallBack<JSONObject> {

    protected T mView;
    private CompositeDisposable mCompositeDisposable;

    protected RetrofitHelper mRetrofitHelper;
    private int i;  // 网络请求个数，用于判断是否hideLoading


    @Override
    public CompositeDisposable getmCompositeDisposable(){
        return mCompositeDisposable;
    }

    @Override
    public void addSubscribe(Disposable disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }

    @Override
    public boolean remove(Disposable disposable) {
        return mCompositeDisposable != null && mCompositeDisposable.remove(disposable);
    }

    @Override
    public void unSubscribe() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.dispose();
        }
    }

    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
    }


    @Override
    public void onStart(int tag, boolean showLoad) {
        if (!showLoad){
            return;
        }
        i++;
        mView.showLoading();
    }

    @Override
    public void onError(int tag, Throwable throwable) {

    }

    @Override
    public void onComplete(int tag, boolean showLoad) {
        if (!showLoad){
            return;
        }
        i--;
        if (i == 0){
            mView.hideLoading();
        }
    }

    @Override
    public void onSuccess(int tag, JSONObject t) {
        if ("成功".equals(JsonUtils.getString(t, "状态"))){
            try {
                onSuccess2(tag, t);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onSuccess2(int tag, JSONObject response) throws JSONException {

    }
}
