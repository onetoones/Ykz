package com.example.administrator.ykz.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.ykz.R;

import butterknife.ButterKnife;

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView{
public T presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        ButterKnife.bind(this);

        presenter = getPresenter();
        if (presenter!=null){
            presenter.BasePresenter(this);
        }
        initData();
    }

    protected abstract void initData();

    protected abstract int setLayout();

   protected abstract T getPresenter();
}
