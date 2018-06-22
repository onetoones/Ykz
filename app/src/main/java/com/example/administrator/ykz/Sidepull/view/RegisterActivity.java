package com.example.administrator.ykz.Sidepull.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.ykz.R;
import com.example.administrator.ykz.Sidepull.presenter.RegisterPresenter;
import com.example.administrator.ykz.Sidepull.view.iview.IRegisterActivity;
import com.example.administrator.ykz.base.BaseActivity;
import com.example.administrator.ykz.base.MyBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity<RegisterPresenter> implements IRegisterActivity {


    @BindView(R.id.register_fanhui)
    ImageView registerFanhui;
    @BindView(R.id.register_zc)
    TextView registerZc;
    @BindView(R.id.register_zh)
    EditText registerZh;
    @BindView(R.id.register_mm)
    EditText registerMm;
    @BindView(R.id.signin_zc)
    Button signinDl;

    //下面三个抽取的基类
    //点击事件
    @Override
    protected void initData() {

    }

    //布局
    @Override
    protected int setLayout() {
        return R.layout.activity_register;
    }

    //和p层交互也抽出去
    @Override
    protected RegisterPresenter getPresenter() {

        return new RegisterPresenter();
    }

    @OnClick({R.id.register_fanhui, R.id.register_zc, R.id.signin_zc})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.register_fanhui:
                finish();
                break;
            case R.id.register_zc:
                finish();
                break;
            case R.id.signin_zc:
                String mobile = registerZh.getText().toString().trim();
                String pwd = registerMm.getText().toString().trim();
                presenter.getRes(mobile, pwd);

                break;
        }
    }

    //实现接口方法
    @Override
    public void getRegisterShow(MyBean bean) {
        String code = bean.getCode();
        int i = Integer.parseInt(code);
        if (i == 0) {
            startActivity(new Intent(this, SigninActivity.class));
        }else {
            Toast.makeText(this, bean.getMsg(), Toast.LENGTH_LONG).show();
        }

    }
    @Override
    public void show(String str) {
        Toast.makeText(this, str, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroys();
    }
}
