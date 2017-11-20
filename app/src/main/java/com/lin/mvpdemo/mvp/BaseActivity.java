package com.lin.mvpdemo.mvp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.lin.mvpdemo.App;
import com.lin.mvpdemo.di.component.ActivityComponent;
import com.lin.mvpdemo.di.component.DaggerActivityComponent;
import com.lin.mvpdemo.di.module.AcitvityModule;
import com.lin.mvpdemo.utils.LoadDialog;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * @author ljz.
 * @date 2017/11/15
 * 描述：BaseActivity
 */

public abstract class BaseActivity<T extends BaseContract.BasePresenter> extends AppCompatActivity implements BaseContract.BaseView{

    @Inject
    protected T mPresenter;
    protected Context mContext;
    private LoadDialog loadDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initResource());
        ButterKnife.bind(this);
        mContext = this;
        loadDialog = new LoadDialog(this);
        initInject();
        initPresenter();
        initData();
    }

    /**
     * 初始化布局资源文件
     */
    public abstract int initResource();

    /**
     * 依赖注入
     */
    public abstract void initInject();

    /**
     * 初始化数据
     */
    public abstract void initData();

    /**
     * Presenter绑定View
     */
    private void initPresenter(){
        mPresenter.attachView(this);
    }

    protected ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder()
                .appComponent(App.getInstance().getAppComponent())
                .acitvityModule(new AcitvityModule(this))
                .build();
    }

    @Override
    public void showLoading() {
        loadDialog.show(mPresenter.getmCompositeDisposable());
    }

    @Override
    public void hideLoading() {
        loadDialog.dismiss();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loadDialog.dismiss();
        mPresenter.detachView();
    }
}
