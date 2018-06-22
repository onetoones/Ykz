package com.example.administrator.ykz.hot.model.idodel;

import com.example.administrator.ykz.hot.bean.AdvertisementBean;
import com.example.administrator.ykz.hot.bean.HotBean;
import com.example.administrator.ykz.net.OnNetListner;

public interface IAdverModel {

    void getAdver(OnNetListner<AdvertisementBean> onNetListner);

    void getVideo(String page, String source, String token, String appVersion, OnNetListner<HotBean> onNetListner);
}
