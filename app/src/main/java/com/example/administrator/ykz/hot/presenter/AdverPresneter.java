package com.example.administrator.ykz.hot.presenter;

import android.util.Log;

import com.example.administrator.ykz.base.BaseFragment;
import com.example.administrator.ykz.base.BasePresenter;
import com.example.administrator.ykz.hot.bean.AdvertisementBean;
import com.example.administrator.ykz.hot.bean.HotBean;
import com.example.administrator.ykz.hot.model.AdverModel;
import com.example.administrator.ykz.hot.model.idodel.IAdverModel;
import com.example.administrator.ykz.hot.view.iview.IZHotFragment;
import com.example.administrator.ykz.net.OnNetListner;

public class AdverPresneter extends BasePresenter<IZHotFragment>{
    private IAdverModel model = new AdverModel();
    private IZHotFragment activitys;

    public void adver(){
        activitys = getActivitys();
        model.getAdver(new OnNetListner<AdvertisementBean>() {
            @Override
            public void onSuccess(AdvertisementBean bean) {
                activitys.gethot(bean);
            }

            @Override
            public void onFaile(Exception e) {

            }
        });

    }
//视频
    public void hots(String page, String source, String token, String appVersion){

        model.getVideo(page, source, token, appVersion, new OnNetListner<HotBean>() {
            @Override
            public void onSuccess(HotBean hotBean) {
                activitys.getVideos(hotBean);
            }

            @Override
            public void onFaile(Exception e) {

            }
        });

    }

}
