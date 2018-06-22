package com.example.administrator.ykz.Paragraph.presenter;

import com.example.administrator.ykz.Paragraph.bean.ParagBean;
import com.example.administrator.ykz.Paragraph.model.ParagModel;
import com.example.administrator.ykz.Paragraph.model.imodel.IParagModel;
import com.example.administrator.ykz.Paragraph.view.iview.IParagrapFragment;
import com.example.administrator.ykz.base.BasePresenter;
import com.example.administrator.ykz.net.OnNetListner;

public class ParagPresenter extends BasePresenter<IParagrapFragment> {
private IParagModel model = new ParagModel();
    private IParagrapFragment activitys;


    public void getparagrap(String page, String source, String token, String appVersion){
        activitys = getActivitys();
        model.getParag(page, source, token, appVersion, new OnNetListner<ParagBean>() {
            @Override
            public void onSuccess(ParagBean bean) {
                activitys.getshow(bean);
            }

            @Override
            public void onFaile(Exception e) {

            }
        });
}


}
