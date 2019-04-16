package com.example.zq.mvpdesignpattern.network.callback;


import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by zq on 2019/4/9.
 */

public class RequestCallbacks implements Callback {

    private final ISuccess mSuccess;
    private final IFailure mFailure;
    private final IError mError;
    private final IRequest mRequest;

    public RequestCallbacks(ISuccess success, IFailure failure, IError error, IRequest request) {
        this.mSuccess = success;
        this.mFailure = failure;
        this.mError = error;
        this.mRequest = request;
    }


    @Override
    public void onResponse(Call call, Response response) {
        if (response.isSuccessful()) {
            if (call.isExecuted()) {
                if (mSuccess != null) {
                    mSuccess.onSuccess(response.body().toString());
                }
            }
        } else {
            if (mError != null) {
                mError.onError(response.code(), response.message());
            }
        }
    }

    @Override
    public void onFailure(Call call, Throwable t) {
        Log.e("onFailure::", t.getStackTrace().toString());
        Log.e("onFailure::", t.getMessage().toString());
        if (mFailure != null) {
            mFailure.onFailure();
        }
    }
}
