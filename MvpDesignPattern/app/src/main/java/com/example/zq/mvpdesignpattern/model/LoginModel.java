package com.example.zq.mvpdesignpattern.model;


import android.os.Handler;

import com.example.zq.mvpdesignpattern.callback.MvpCallback;
import com.example.zq.mvpdesignpattern.network.RestClient;
import com.example.zq.mvpdesignpattern.network.callback.IRequest;

public class LoginModel {

    public static void requestGet(String username, String password, final MvpCallback<String> callback) {
        RestClient.builder()
                .baseUrl(username)
                .url(password)
                .onSuccess(response -> {callback.onSuccess("请求网络数据成功");})
                .onError(((code, msg) -> {callback.onError();}))
                .onFailure(() -> {callback.onFailure("请求失败，参数有误");})
                .onRequest(new IRequest() {
                    @Override
                    public void onRequestStart() {
                    }

                    @Override
                    public void onRequestEnd() {
                    }
                })
                .build()
                .get();
        //模仿网络延迟，请求花费一定时间
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                callback.onComplete();
            }
        },2000);
    }
}
