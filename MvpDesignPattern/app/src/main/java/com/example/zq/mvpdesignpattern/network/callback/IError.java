package com.example.zq.mvpdesignpattern.network.callback;

/**
 * Created by zq on 2019/4/9.
 */

public interface IError {

    void onError(int code, String msg);

}
