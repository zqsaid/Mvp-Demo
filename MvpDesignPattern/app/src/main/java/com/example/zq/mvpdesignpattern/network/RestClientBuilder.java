package com.example.zq.mvpdesignpattern.network;

import android.content.Context;

import com.example.zq.mvpdesignpattern.network.callback.IError;
import com.example.zq.mvpdesignpattern.network.callback.IFailure;
import com.example.zq.mvpdesignpattern.network.callback.IRequest;
import com.example.zq.mvpdesignpattern.network.callback.ISuccess;

import java.util.WeakHashMap;

import okhttp3.RequestBody;

/**
 * Created by zq on 2019/4/9.
 * 建造者模式创建RestClientBuilder，方便我们在业务代码中链式调用
 */

public class RestClientBuilder {

    private final WeakHashMap<String, Object> mParamsMap = new WeakHashMap<>();

    private String mUrl = null;
    private IRequest mIRequest = null;
    private ISuccess mISuccess = null;
    private IFailure mIFailure = null;
    private IError mIError = null;

    private RequestBody mBody = null;
    private Context mContext = null;

    RestClientBuilder() {

    }

    public final RestClientBuilder baseUrl(String baseUrl) {
        BaseUrl.BASE_URL = baseUrl;
        return this;
    }

    public final RestClientBuilder url(String url) {
        this.mUrl = url;
        return this;

    }

    public final RestClientBuilder params(WeakHashMap<String, Object> params) {
        mParamsMap.putAll(params);
        return this;

    }

    public final RestClientBuilder params(String key, Object value) {
        mParamsMap.put(key, value);
        return this;

    }

    public final RestClientBuilder onRequest(IRequest request) {
        this.mIRequest = request;
        return this;

    }

    public final RestClientBuilder onSuccess(ISuccess success) {
        this.mISuccess = success;
        return this;
    }

    public final RestClientBuilder onFailure(IFailure failure) {
        this.mIFailure = failure;
        return this;
    }

    public final RestClientBuilder onError(IError error) {
        this.mIError = error;
        return this;
    }

    public final RestClient build() {
        return new RestClient(mUrl, mParamsMap, mIRequest, mISuccess, mIFailure,
                mIError, mBody, mContext);
    }
}
