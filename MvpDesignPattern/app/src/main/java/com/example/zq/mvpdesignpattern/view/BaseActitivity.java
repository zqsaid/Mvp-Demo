package com.example.zq.mvpdesignpattern.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.zq.mvpdesignpattern.util.DialogUtils;

public abstract class BaseActitivity extends AppCompatActivity implements LoginView{
    private static final String TAG = "BaseActitivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DialogUtils.getInstance().init(this);
    }

    @Override
    public void showProgressDialog() {
        Log.i(TAG, "showProgressDialog: show");
        DialogUtils.getInstance().show();
    }

    @Override
    public void hideProgerssDialog() {
        Log.i(TAG, "hideProgerssDialog: hide");
        DialogUtils.getInstance().dissmiss();
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError() {
        showToast("error");
    }

    @Override
    public Context getContext() {
        return BaseActitivity.this;
    }

    @Override
    public void showData(String msg) {
        showToast("success");
    }
}
