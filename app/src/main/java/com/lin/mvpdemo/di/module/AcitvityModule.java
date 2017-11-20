package com.lin.mvpdemo.di.module;

import android.app.Activity;

import com.lin.mvpdemo.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * @author ljz.
 * @date 2017/11/15
 * 描述：Activity模型
 */
@Module
public class AcitvityModule {

    private Activity activity;

    public AcitvityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    public Activity provideView() {
        return activity;
    }
}
