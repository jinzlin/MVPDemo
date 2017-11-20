package com.lin.mvpdemo.network;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * @author ljz.
 * @date 2017/11/20.
 * 描述：自定义转换器(JSONObject Converter)
 * 不需要Gson以及其他转换器，只是单纯的返回 JSONObject
 * http://blog.csdn.net/jdsjlzx/article/details/51520954
 */

public class JsonConverterFactory extends Converter.Factory {

    public static JsonConverterFactory create() {
        return new JsonConverterFactory();
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new JsonResponseBodyConverter<JSONObject>();
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        return new JsonRequestBodyConverter<JSONObject>();
    }

    private class JsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {

        JsonResponseBodyConverter() {

        }

        @Override
        public T convert(ResponseBody value) throws IOException {
            JSONObject jsonObj;
            try {
                jsonObj = new JSONObject(value.string());
                return (T) jsonObj;
            } catch (JSONException e) {
                return null;
            }
        }
    }

    private class JsonRequestBodyConverter<T> implements Converter<T, RequestBody> {
        private final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");

        JsonRequestBodyConverter() {

        }

        @Override
        public RequestBody convert(T value) throws IOException {
            return RequestBody.create(MEDIA_TYPE, value.toString());
        }
    }
}


