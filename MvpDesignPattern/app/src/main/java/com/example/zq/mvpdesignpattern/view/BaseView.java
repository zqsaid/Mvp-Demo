package com.example.zq.mvpdesignpattern.view;

import android.content.Context;

public interface BaseView {

    void showProgressDialog();

    void hideProgerssDialog();

    void showToast(String msg);

    void showError();

    Context getContext();
}
