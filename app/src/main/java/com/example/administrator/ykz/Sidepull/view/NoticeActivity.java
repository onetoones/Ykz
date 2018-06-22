package com.example.administrator.ykz.Sidepull.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.administrator.ykz.R;
import com.example.administrator.ykz.base.BaseActivity;
import com.example.administrator.ykz.base.BasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NoticeActivity extends BaseActivity {

    @BindView(R.id.notice_fh)
    TextView noticeFh;
    @Override
    protected void initData() {

    }

    @Override
    protected int setLayout() {
        return R.layout.activity_notice;
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @OnClick(R.id.notice_fh)
    public void onViewClicked() {
        finish();
    }
}
