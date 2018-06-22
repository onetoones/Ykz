package com.example.administrator.ykz.Sidepull.model;

import com.example.administrator.ykz.Sidepull.model.imodel.IRegisterModel;
import com.example.administrator.ykz.base.MyBean;
import com.example.administrator.ykz.net.Api;
import com.example.administrator.ykz.net.OkRetrofiter;
import com.example.administrator.ykz.net.OnNetListner;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RegisterModel implements IRegisterModel {
    @Override
    public void getRegister(String name, String pwd, final OnNetListner<MyBean> onNetListner) {
        Observable<MyBean> rigisters = OkRetrofiter.getApi(Api.Host).rigisters(name, pwd);

        rigisters.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<MyBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MyBean myBean) {
                        onNetListner.onSuccess(myBean);
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
