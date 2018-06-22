package com.example.administrator.ykz.Sidepull.model;

import com.example.administrator.ykz.Sidepull.bean.SigninBean;
import com.example.administrator.ykz.Sidepull.model.imodel.ISigninModle;
import com.example.administrator.ykz.net.Api;
import com.example.administrator.ykz.net.OkRetrofiter;
import com.example.administrator.ykz.net.OnNetListner;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SigninModel implements ISigninModle {
    @Override
    public void getSign(String name, String pwd, final OnNetListner<SigninBean> onNetListner) {
        Observable<SigninBean> signins = OkRetrofiter.getApi(Api.Host).signins(name, pwd);

        signins.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<SigninBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SigninBean signinBean) {
                        onNetListner.onSuccess(signinBean);
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
