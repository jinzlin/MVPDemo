package com.lin.mvpdemo.di.module;

import android.content.Context;

import com.lin.mvpdemo.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author ljz.
 * @date 2017/11/15
 * 描述:App模型
 */
@Module
public class AppModule {

    private Context context;

    public AppModule(App app){
        context = app;
    }

    @Provides
    public Context providerAppContext(){
        return context;
    }
}
