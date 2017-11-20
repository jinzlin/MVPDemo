package com.lin.mvpdemo.di.component;

import android.content.Context;

import com.lin.mvpdemo.di.module.ApiModule;
import com.lin.mvpdemo.di.module.AppModule;
import com.lin.mvpdemo.network.RetrofitHelper;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author ljz.
 * @date 2017/11/15
 */
@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface AppComponent {

    RetrofitHelper getRetrofitHelper();

    Context getContext();
}
