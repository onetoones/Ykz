package com.example.administrator.ykz.net;

import com.example.administrator.ykz.Paragraph.bean.ParagBean;
import com.example.administrator.ykz.hot.bean.AdvertisementBean;
import com.example.administrator.ykz.Sidepull.bean.SigninBean;
import com.example.administrator.ykz.base.MyBean;
import com.example.administrator.ykz.hot.bean.HotBean;

import io.reactivex.Observable;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetrofiterAPI {
    //注册
    @POST("quarter/register")
    @FormUrlEncoded
    Observable<MyBean> rigisters(@Field("mobile") String mobile, @Field("password") String password);

    //登录
    @POST("user/login")
    @FormUrlEncoded
    Observable<SigninBean> signins(@Field("mobile") String mobile, @Field("password") String password);

    //广告
    @GET("quarter/getAd")
    Observable<AdvertisementBean> advert();


    //热门视频
    @POST("quarter/getHotVideos")
    @FormUrlEncoded
    Observable<HotBean> hotVideo(@Field("page") String page, @Field("source") String source, @Field("token") String token, @Field("appVersion") String appVersion);

    //段子
    @POST("quarter/getJokes")
    @FormUrlEncoded
    Observable<ParagBean> parags(@Field("page") String page, @Field("source") String source, @Field("token") String token, @Field("appVersion") String appVersion);
}