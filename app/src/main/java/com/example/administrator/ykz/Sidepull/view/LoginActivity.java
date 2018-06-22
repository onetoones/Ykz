package com.example.administrator.ykz.Sidepull.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.ykz.R;
import com.example.administrator.ykz.base.BaseActivity;
import com.example.administrator.ykz.base.BasePresenter;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.simpleDraweeView)
    SimpleDraweeView simpleDraweeView;
    @BindView(R.id.simpleDraweeView3)
    SimpleDraweeView simpleDraweeView3;
    @BindView(R.id.text_qita)
    TextView textQita;
    @BindView(R.id.fanhui)
    ImageView fanhui;

    @Override
    protected void initData() {

    }

    @Override
    protected int setLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @OnClick({R.id.simpleDraweeView, R.id.simpleDraweeView3, R.id.text_qita, R.id.fanhui})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.simpleDraweeView:
                break;
            case R.id.simpleDraweeView3:
                break;
            case R.id.text_qita:
                startActivity(new Intent(this,SigninActivity.class));
                break;
            case R.id.fanhui:
                finish();
                break;
        }
    }
}
