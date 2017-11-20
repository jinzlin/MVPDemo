package com.lin.mvpdemo.network;

import org.json.JSONObject;

import java.util.Map;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * @author ljz.
 * @date 2017/11/15.
 * 描述：
 */

public interface ApiService {

    @GET("api.post")
    Observable<JSONObject> doGet(@QueryMap Map<String, String> maps);

    @FormUrlEncoded
    @POST("api.post")
    Observable<JSONObject> doPost(@FieldMap Map<String, String> maps);
}
