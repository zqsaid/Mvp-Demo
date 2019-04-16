package com.example.zq.mvpdesignpattern.presenter;

import com.example.zq.mvpdesignpattern.view.BaseView;

public class BasePresenter<T extends BaseView> {
    private T mView;

    public void attachView(T view) {
        this.mView = view;
    }

    public void detachView() {
        this.mView = null;
    }

    public boolean isViewAttachView() {
        return mView != null;
    }

    public T getView() {
        return mView;
    }
}
