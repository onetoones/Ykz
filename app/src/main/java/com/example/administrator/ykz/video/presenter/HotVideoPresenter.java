package com.example.administrator.ykz.video.presenter;

import com.example.administrator.ykz.base.BasePresenter;
import com.example.administrator.ykz.hot.bean.HotBean;
import com.example.administrator.ykz.hot.model.AdverModel;
import com.example.administrator.ykz.hot.model.idodel.IAdverModel;
import com.example.administrator.ykz.net.OnNetListner;
import com.example.administrator.ykz.video.view.iview.IHotVideoFragment;

public class HotVideoPresenter extends BasePresenter<IHotVideoFragment>{
    private IAdverModel model = new AdverModel();
    private IHotVideoFragment activitys;

    public void paragver(String page, String source, String token, String appVersion){
        activitys = getActivitys();
        model.getVideo(page, source, token, appVersion, new OnNetListner<HotBean>() {
            @Override
            public void onSuccess(HotBean bean) {
                activitys.hots(bean);
            }

            @Override
            public void onFaile(Exception e) {

            }
        });
    }

}
