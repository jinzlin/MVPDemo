package com.lin.mvpdemo.mvp.info;

import com.lin.mvpdemo.mvp.BaseContract;

/**
 * @author ljz.
 * @date 2017/11/15
 */

public interface InfoContract {

    interface View extends BaseContract.BaseView{

        void showToash(String s);

        void showText(String s);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T>{

        void setText(String s);
    }
}
