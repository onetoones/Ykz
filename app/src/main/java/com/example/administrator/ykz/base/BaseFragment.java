package com.example.administrator.ykz.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<T extends BasePresenter> extends Fragment implements BaseView{
    public View view;
    Unbinder unbinder;
    public T presenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = View.inflate(getActivity(), setLayout(), null);
        unbinder = ButterKnife.bind(this, view);
        presenter = setPresenter();
        if (presenter!=null){
            presenter.BasePresenter(this);
        }

        initData();
        return view;
    }

    protected abstract T setPresenter();

    protected abstract void initData();

    protected abstract int setLayout();

}
