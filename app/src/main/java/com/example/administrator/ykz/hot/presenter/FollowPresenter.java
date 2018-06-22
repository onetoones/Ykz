package com.example.administrator.ykz.hot.presenter;

import com.example.administrator.ykz.base.BasePresenter;
import com.example.administrator.ykz.hot.bean.HotBean;
import com.example.administrator.ykz.hot.model.AdverModel;
import com.example.administrator.ykz.hot.model.idodel.IAdverModel;
import com.example.administrator.ykz.hot.view.iview.IFollowFragment;
import com.example.administrator.ykz.net.OnNetListner;

public class FollowPresenter extends BasePresenter<IFollowFragment>{
    private IAdverModel model = new AdverModel();
    private IFollowFragment activitys;

    public void getFollow(String page, String source, String token, String appVersion){
        activitys = getActivitys();
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
