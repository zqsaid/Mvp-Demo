package com.example.zq.mvpdesignpattern.network;

import android.content.Context;

import com.example.zq.mvpdesignpattern.network.callback.IError;
import com.example.zq.mvpdesignpattern.network.callback.IFailure;
import com.example.zq.mvpdesignpattern.network.callback.IRequest;
import com.example.zq.mvpdesignpattern.network.callback.ISuccess;
import com.example.zq.mvpdesignpattern.network.callback.RequestCallbacks;

import java.util.WeakHashMap;

import okhttp3.RequestBody;
import retrofit2.Call;

/**
 * Created by zq on 2019/4/9.
 * 构建RestClientBuilder对象，进行具体的网络操作
 */

public class RestClient {

    private final WeakHashMap<String, Object> mParamsMap;
    private final String mUrl;
    private final IRequest mIRequest;
    private final ISuccess mISuccess;
    private final IFailure mIFailure;
    private final IError mIError;
    private final RequestBody mBody;
    private final Context mContext;


    public RestClient(String mUrl,
                      WeakHashMap<String, Object> params,
                      IRequest mIRequest,
                      ISuccess mISuccess,
                      IFailure mIFailure,
                      IError mIError,
                      RequestBody mBody,
                      Context mContext) {
        this.mUrl = mUrl;
        this.mParamsMap = params;
        this.mIRequest = mIRequest;
        this.mISuccess = mISuccess;
        this.mIFailure = mIFailure;
        this.mIError = mIError;
        this.mBody = mBody;
        this.mContext = mContext;
    }


    public static RestClientBuilder builder() {
        return new RestClientBuilder();
    }

    private void request(HttpMethod method) {
        final RestService service = RestCreator.getRestService();
        Call<String> call = null;

        if (mIRequest != null) {
            mIRequest.onRequestStart();
        }

        switch (method) {
            case GET:
                call = service.get(mUrl, mParamsMap);
                break;
            case POST:
                call = service.post(mUrl, mParamsMap);
                break;
            case PUT:
                call = service.put(mUrl, mParamsMap);
                break;
            case DELETE:
                call = service.delete(mUrl, mParamsMap);
                break;
            case DOWNLOAD:
                //TODO
                break;
            case UPLOAD:
                //TODO
                break;

            default:
                break;
        }

        if (call != null) {
            call.enqueue(getRequestCallBack());

        }
    }

    private RequestCallbacks getRequestCallBack() {

        return new RequestCallbacks(
                mISuccess,
                mIFailure,
                mIError,
                mIRequest);
    }

    public final void get() {
        request(HttpMethod.GET);
    }

    public final void post() {
        request(HttpMethod.POST);
    }
}
