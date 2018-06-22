package com.example.administrator.ykz.Sidepull.view;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.ykz.MainActivity;
import com.example.administrator.ykz.R;
import com.example.administrator.ykz.Sidepull.bean.SigninBean;
import com.example.administrator.ykz.Sidepull.model.imodel.ISigninModle;
import com.example.administrator.ykz.Sidepull.presenter.SigninPresenter;
import com.example.administrator.ykz.Sidepull.view.iview.ISigninActivity;
import com.example.administrator.ykz.base.BaseActivity;
import com.example.administrator.ykz.base.BasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SigninActivity extends BaseActivity<SigninPresenter> implements ISigninActivity{


    @BindView(R.id.fanhui)
    ImageView fanhui;
    @BindView(R.id.signin_zc)
    TextView signinZc;
    @BindView(R.id.signin_zh)
    EditText signinZh;
    @BindView(R.id.signin_mm)
    EditText signinMm;
    @BindView(R.id.signin_dl)
    Button signinDl;
    @BindView(R.id.signin_wjmm)
    TextView signinWjmm;

    @Override
    protected void initData() {

    }

    @Override
    protected int setLayout() {
        return R.layout.activity_signin;
    }

    @Override
    protected SigninPresenter getPresenter() {
        return new SigninPresenter();
    }


    @OnClick({R.id.fanhui, R.id.signin_zc, R.id.signin_dl})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fanhui:
                finish();
                break;
            case R.id.signin_zc:
                startActivity(new Intent(this,RegisterActivity.class));
                break;
            case R.id.signin_dl:
                String name = signinZh.getText().toString().trim();
                String pwd = signinMm.getText().toString().trim();
                presenter.getRes(name,pwd);

                break;
        }
    }

    @Override
    public void getSigninShow(SigninBean bean) {
        String code = bean.getCode();
        int i = Integer.parseInt(code);
        if (i == 0) {
            SharedPreferences sp = getSharedPreferences("Users", Context.MODE_PRIVATE);
            SharedPreferences.Editor edit = sp.edit();
            edit.putString("token",bean.getData().getToken());
            edit.putString("uid",bean.getData().getUid()+"");
            edit.commit();

            startActivity(new Intent(this, MainActivity.class));

        }else {
            Toast.makeText(this, bean.getMsg(), Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void show(String str) {

        Toast.makeText(this,str,Toast.LENGTH_LONG).show();

    }
}
