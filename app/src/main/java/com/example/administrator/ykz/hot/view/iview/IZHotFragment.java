package com.example.administrator.ykz.hot.view.iview;

import com.example.administrator.ykz.base.BaseView;
import com.example.administrator.ykz.hot.bean.AdvertisementBean;
import com.example.administrator.ykz.hot.bean.HotBean;

public interface IZHotFragment extends BaseView{
    void gethot(AdvertisementBean bean);
    void getVideos(HotBean bean);
}
