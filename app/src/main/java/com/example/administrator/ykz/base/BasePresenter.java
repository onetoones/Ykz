package com.example.administrator.ykz.base;

public class BasePresenter<T extends BaseView> {
    public T activitys;

    public void BasePresenter(T activitys) {
        this.activitys = activitys;
    }

    public void onDestroys() {
        activitys = null;
    }

    public T getActivitys() {
        return activitys;
    }

}
