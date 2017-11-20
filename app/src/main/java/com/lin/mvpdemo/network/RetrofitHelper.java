package com.lin.mvpdemo.network;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author ljz.
 * @date 2017/11/17.
 * 描述：
 */

public class RetrofitHelper {

    private Disposable disposable;

    private final ApiService mApiService;

    public RetrofitHelper(ApiService apiService) {
        this.mApiService = apiService;
    }


    private Disposable getDisposable(int tag, Map<String, String> map, HttpCallBack httpCallBack, boolean showLoad) {
        mApiService.doPost(map)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseSubscriber<JSONObject>(httpCallBack, tag, showLoad) {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        super.onSubscribe(d);
                        disposable = d;
                    }
                });
        return disposable;
    }

    public Disposable info1(int tag, HttpCallBack httpCallBack, String words) {

        Map<String, String> map = new HashMap<>();
        map.put("func", "p_bonus_points_Version2.0.0");
        map.put("words", words);

        return getDisposable(tag, map, httpCallBack, true);
    }

    public Disposable info2(int tag, HttpCallBack httpCallBack, String words, String a) {

        Map<String, String> map = new HashMap<>();
        map.put("func", "p_bonus_points_Version2.0.0");
        map.put("words", words);

        return getDisposable(tag, map, httpCallBack, false);
    }
}
