package com.example.administrator.ykz.net;

public interface OnNetListner<T> {
    void onSuccess(T t);
    void onFaile(Exception e);
}
