package com.example.administrator.ykz.Sidepull.model.imodel;

import com.example.administrator.ykz.base.MyBean;
import com.example.administrator.ykz.net.OnNetListner;

public interface IRegisterModel {
    void getRegister(String name, String pwd, OnNetListner<MyBean> onNetListner);
}
