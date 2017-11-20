package com.lin.mvpdemo.mvp.main;

import com.lin.mvpdemo.mvp.BaseContract;

/**
 * @author ljz.
 * @date 2017/11/15
 */

public interface MainContract {

    interface View extends BaseContract.BaseView{
        void showToash(String s);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T>{
        void showToash(String s);
    }
}
