package com.example.zq.mvpdesignpattern.presenter;

import android.util.Log;

import com.example.zq.mvpdesignpattern.callback.MvpCallback;
import com.example.zq.mvpdesignpattern.model.LoginModel;
import com.example.zq.mvpdesignpattern.view.LoginView;

public class LoginPresenter extends BasePresenter<LoginView>{
    private static final String TAG = "LoginPresenter";

    public void login(String username, String password) {
        if (!isViewAttachView()) {
            return;
        }

        getView().showProgressDialog();
        LoginModel.requestGet(username, password, new MvpCallback<String>() {
            @Override
            public void onSuccess(String data) {
                Log.i(TAG, "onSuccess: ");
                if(isViewAttachView()){
                    getView().showData(data);
                }
            }

            @Override
            public void onFailure(String msg) {
                Log.i(TAG, "onFailure: ");
                if(isViewAttachView()) {
                    getView().showToast(msg);
                }
            }

            @Override
            public void onError() {
                Log.i(TAG, "onError: ");
                if(isViewAttachView()){
                    getView().showError();
                }
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "onComplete: ");
                if(isViewAttachView()){
                    getView().hideProgerssDialog();
                }
            }
        });
    }
}
