package com.example.administrator.ykz.Sidepull.view;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.ykz.R;
import com.example.administrator.ykz.base.BaseActivity;
import com.example.administrator.ykz.base.BasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyFollowActivity extends BaseActivity {

    @BindView(R.id.myfollow_fh)
    TextView myfollowFh;
    @BindView(R.id.myfollow_hot)
    TextView myfollowHot;



    @Override
    protected void initData() {

    }

    @Override
    protected int setLayout() {
        return R.layout.activity_my_follow;
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @OnClick({R.id.myfollow_fh, R.id.myfollow_hot})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.myfollow_fh:
                finish();
                break;
            case R.id.myfollow_hot:
                break;
        }
    }
}
