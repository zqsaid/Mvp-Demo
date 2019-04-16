package com.example.zq.mvpdesignpattern.view;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.zq.mvpdesignpattern.R;
import com.example.zq.mvpdesignpattern.presenter.LoginPresenter;

public class LoginActivity extends BaseActitivity {

    private TextView mTextViewShow;
    private EditText mEditAccount;
    private EditText mEditPassword;
    private LoginPresenter mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mPresenter = new LoginPresenter();
        mPresenter.attachView(this);
        TextView textView = findViewById(R.id.text_view);
        mEditAccount = findViewById(R.id.edit_account);
        mEditPassword = findViewById(R.id.edit_password);
        mTextViewShow = findViewById(R.id.text_view_show);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.login(getUsername(), getPassword());
            }
        });
    }

    private String getUsername() {
        return mEditAccount.getText().toString().trim();
    }

    private String getPassword() {
        return mEditPassword.getText().toString().trim();
    }

    @Override
    public void showData(String msg) {
        super.showData(msg);
        mTextViewShow.setText(msg);
    }

    @Override
    public void showError() {
        super.showError();
        mTextViewShow.setText("error");
    }
}
