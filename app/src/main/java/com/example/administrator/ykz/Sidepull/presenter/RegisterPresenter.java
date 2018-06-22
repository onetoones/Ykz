package com.example.administrator.ykz.Sidepull.presenter;

import android.text.TextUtils;

import com.example.administrator.ykz.Sidepull.model.RegisterModel;
import com.example.administrator.ykz.Sidepull.model.imodel.IRegisterModel;
import com.example.administrator.ykz.Sidepull.view.iview.IRegisterActivity;
import com.example.administrator.ykz.base.BasePresenter;
import com.example.administrator.ykz.base.BaseView;
import com.example.administrator.ykz.base.MyBean;
import com.example.administrator.ykz.net.OnNetListner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterPresenter extends BasePresenter<IRegisterActivity>{
 private IRegisterModel model = new RegisterModel();
    private IRegisterActivity activity;

    public void getRes(String mobile,String passworld){
        activity = getActivitys();
     if (checkAccount(mobile) && checkmm(passworld)) {
         model.getRegister(mobile, passworld, new OnNetListner<MyBean>() {
             @Override
             public void onSuccess(MyBean bean) {
                 activity.getRegisterShow(bean);
             }

             @Override
             public void onFaile(Exception e) {

             }
         });

     }
 }

    private boolean checkmm(String passworld) {
        if (TextUtils.isEmpty(passworld)) {
            activity.show("请输入密码");
            return false;
        }
        if (passworld.length() != 6) {
            activity.show("请输入六位数密码");
            return false;
        }
        return true;
    }

    private boolean checkAccount(String mobile) {
        if (TextUtils.isEmpty(mobile)) {
            activity.show("请输入账号");
            return false;
        }
        if (!isMobileNO(mobile)) {
            activity.show("请输入正确手机号");
            return false;
        }
        return true;
    }


    /*
判断是否是手机号
 */
    public static boolean isMobileNO(String mobiles) {
        Pattern p = Pattern.compile("^(13[0-9]|14[57]|15[0-35-9]|17[6-8]|18[0-9])[0-9]{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

}
