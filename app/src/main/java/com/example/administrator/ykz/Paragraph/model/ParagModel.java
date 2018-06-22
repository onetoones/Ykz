package com.example.administrator.ykz.Paragraph.model;

import com.example.administrator.ykz.Paragraph.bean.ParagBean;
import com.example.administrator.ykz.Paragraph.model.imodel.IParagModel;
import com.example.administrator.ykz.net.Api;
import com.example.administrator.ykz.net.OkRetrofiter;
import com.example.administrator.ykz.net.OnNetListner;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ParagModel implements IParagModel {
    @Override
    public void getParag(String page, String source, String token, String appVersion, final OnNetListner<ParagBean> onNetListner) {
        Observable<ParagBean> parags = OkRetrofiter.getApi(Api.Host).parags(page, source, token, appVersion);

        parags.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ParagBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ParagBean paragBean) {
                        onNetListner.onSuccess(paragBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        onNetListner.onFaile((Exception) e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
