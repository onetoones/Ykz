package com.example.administrator.ykz;

import android.os.Bundle;
import android.widget.TextView;

import com.example.administrator.ykz.base.BaseActivity;
import com.example.administrator.ykz.base.BasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ALiteraryCreationActivity extends BaseActivity {


    @BindView(R.id.al_fh)
    TextView alFh;

    @Override
    protected void initData() {

    }

    @Override
    protected int setLayout() {
        return R.layout.activity_aliterary_creation;
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }



    @OnClick(R.id.al_fh)
    public void onViewClicked() {
        finish();
    }
}
