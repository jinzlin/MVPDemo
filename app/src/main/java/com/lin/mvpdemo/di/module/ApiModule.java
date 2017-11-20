package com.lin.mvpdemo.di.module;

import com.lin.mvpdemo.di.qualifier.ApiUrl;
import com.lin.mvpdemo.network.ApiService;
import com.lin.mvpdemo.network.JsonConverterFactory;
import com.lin.mvpdemo.network.RetrofitHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * @author ljz.
 * @date 2017/11/15.
 * 描述：
 */
@Module
public class ApiModule {

    public Retrofit createRetrofit(Retrofit.Builder builder, String url) {

        return builder
                .baseUrl(url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(JsonConverterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    public Retrofit.Builder provideRetrofitBuilder() {
        return new Retrofit.Builder();
    }

    @Singleton
    @Provides
    public RetrofitHelper provideRetrofitHelper(ApiService apiService) {
        return new RetrofitHelper(apiService);
    }

    @Singleton
    @Provides
    @ApiUrl
    public Retrofit provideApiRetrofit(Retrofit.Builder builder) {
        return createRetrofit(builder, "http://121.201.67.222:19990/");
    }

    @Singleton
    @Provides
    public ApiService provideApiService(@ApiUrl Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }
}
