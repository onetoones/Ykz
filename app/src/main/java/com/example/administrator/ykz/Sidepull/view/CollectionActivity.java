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

public class CollectionActivity extends BaseActivity {

    @BindView(R.id.collection_fh)
    TextView collectionFh;
    @BindView(R.id.collection_delete)
    TextView collectionDelete;


    @Override
    protected void initData() {

    }

    @Override
    protected int setLayout() {
        return R.layout.activity_collection;
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @OnClick({R.id.collection_fh, R.id.collection_delete})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.collection_fh:
                finish();
                break;
            case R.id.collection_delete:
                break;
        }
    }
}
