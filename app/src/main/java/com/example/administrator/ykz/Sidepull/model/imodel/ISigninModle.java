package com.example.administrator.ykz.Sidepull.model.imodel;

import com.example.administrator.ykz.Sidepull.bean.SigninBean;
import com.example.administrator.ykz.base.MyBean;
import com.example.administrator.ykz.net.OnNetListner;

public interface ISigninModle {
    void getSign(String name, String pwd, OnNetListner<SigninBean> onNetListner);

}
