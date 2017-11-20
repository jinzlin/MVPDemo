package com.lin.mvpdemo.utils;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author ljz.
 * @date 2017/11/20.
 * 描述：JSONObject工具类
 */

public class JsonUtils {

    public static String getString(JSONObject jsonObject, String key){
        return getString(jsonObject, key, "");
    }

    public static String getString(JSONObject jsonObject, String key, String sDefault){
        try{
            return jsonObject.getString(key);
        }catch (JSONException e){
            Log.e("JSONException", e + "");
            return sDefault;
        }
    }
}
