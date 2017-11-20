package com.lin.mvpdemo.di.component;

import android.app.Activity;

import com.lin.mvpdemo.mvp.info.InfoActivity;
import com.lin.mvpdemo.mvp.main.MainActivity;
import com.lin.mvpdemo.di.module.AcitvityModule;
import com.lin.mvpdemo.di.scope.ActivityScope;

import dagger.Component;
import dagger.Subcomponent;


/**
 * @author ljz.
 * @date 2017/11/15
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = AcitvityModule.class)
public interface ActivityComponent {

    Activity getActivity();

    void inject(MainActivity mainActivity);

    void inject(InfoActivity infoActivity);
}
