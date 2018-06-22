package com.example.administrator.ykz.hot.model;

import com.example.administrator.ykz.hot.bean.AdvertisementBean;
import com.example.administrator.ykz.hot.bean.HotBean;
import com.example.administrator.ykz.hot.model.idodel.IAdverModel;
import com.example.administrator.ykz.net.Api;
import com.example.administrator.ykz.net.OkRetrofiter;
import com.example.administrator.ykz.net.OnNetListner;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class AdverModel implements IAdverModel {
    @Override
    public void getAdver(final OnNetListner<AdvertisementBean> onNetListner) {
        Observable<AdvertisementBean> advert = OkRetrofiter.getApi(Api.Host).advert();
        advert.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<AdvertisementBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AdvertisementBean advertisementBean) {
                        onNetListner.onSuccess(advertisementBean);
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

    @Override
    public void getVideo(String page, String source, String token, String appVersion, final OnNetListner<HotBean> onNetListner) {
        Observable<HotBean> video = OkRetrofiter.getApi(Api.Host).hotVideo(page, source, token, appVersion);

        video.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<HotBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HotBean hotBean) {
                        onNetListner.onSuccess(hotBean);
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
