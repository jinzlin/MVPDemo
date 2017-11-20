package com.lin.mvpdemo;

import android.app.Application;

import com.lin.mvpdemo.di.component.AppComponent;
import com.lin.mvpdemo.di.component.DaggerAppComponent;
import com.lin.mvpdemo.di.module.ApiModule;
import com.lin.mvpdemo.di.module.AppModule;
import com.squareup.leakcanary.LeakCanary;

/**
 * @author ljz.
 * @date 2017/11/15
 */

public class App extends Application {

    private static App instance;

    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        LeakCanary.install(this);
    }

    public static App getInstance() {
        return instance;
    }


    public AppComponent getAppComponent() {
        if (appComponent == null){
            setAppComponent();
        }
        return appComponent;
    }

    public void setAppComponent() {
        appComponent = DaggerAppComponent.builder()
                .apiModule(new ApiModule())
                .appModule(new AppModule(this))
                .build();
    }
}
