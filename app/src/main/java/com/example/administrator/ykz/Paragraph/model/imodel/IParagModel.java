package com.example.administrator.ykz.Paragraph.model.imodel;

import com.example.administrator.ykz.Paragraph.bean.ParagBean;
import com.example.administrator.ykz.net.OnNetListner;

public interface IParagModel {

    void getParag(String page, String source, String token, String appVersion, OnNetListner<ParagBean> onNetListner);
}
