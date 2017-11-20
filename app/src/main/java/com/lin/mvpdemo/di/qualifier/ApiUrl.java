package com.lin.mvpdemo.di.qualifier;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author ljz.
 * @date 2017/11/17.
 * 描述：
 */

@Qualifier
@Documented
@Retention(RUNTIME)
public @interface ApiUrl {

}
