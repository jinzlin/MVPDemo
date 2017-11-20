package com.lin.mvpdemo.mvp.main;

import com.lin.mvpdemo.mvp.main.MainContract;
import com.lin.mvpdemo.mvp.BasePresenter;
import com.lin.mvpdemo.network.RetrofitHelper;

import javax.inject.Inject;

/**
 * @author ljz.
 * @date 2017/11/15
 */

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter<MainContract.View>{

    private RetrofitHelper mRetrofitHelper;

    @Inject
    public MainPresenter(RetrofitHelper retrofitHelper){
        mRetrofitHelper = retrofitHelper;
    }

    @Override
    public void showToash(String s) {
        mView.showToash(s);
    }
}
