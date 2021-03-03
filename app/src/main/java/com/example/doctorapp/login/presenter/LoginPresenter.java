package com.example.doctorapp.login.presenter;

import com.example.doctorapp.login.bean.LoginBean;
import com.example.doctorapp.login.bean.LoginBodyBean;
import com.example.doctorapp.login.contract.LoginContract;
import com.example.doctorapp.login.model.LoginModel;
import com.example.doctorapp.utils.ICallBack;
import com.google.gson.Gson;
import com.tencent.mmkv.MMKV;

import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

public class LoginPresenter implements LoginContract.iLoginPresenter {
    private final LoginModel loginModel;
    private LoginContract.iLoginView iLoginView;

    public LoginPresenter(LoginContract.iLoginView iLoginView) {
        this.iLoginView = iLoginView;
        loginModel = new LoginModel();
    }

    @Override
    public void getLoginPresenter(String model,String password) {

        LoginBodyBean loginBodyBean = new LoginBodyBean();
        loginBodyBean.setClientId("lkb65617f842ad4c37895a733b8de43cbb");
        loginBodyBean.setMobile(model);
        loginBodyBean.setPassword(password);
        loginBodyBean.setLoginType("2");

        Gson gson = new Gson();
        String json = gson.toJson(loginBodyBean);
        //请求体
        RequestBody body = RequestBody.create(MediaType.parse("application/json"),json);

        loginModel.getLoginModel("user/api/user/login/password",body, new ICallBack<LoginBean>() {
            @Override
            public void onSuccess(LoginBean loginBean) {
                //判断
                if(loginBean.getCode()==200){
                    //保存Token
                    MMKV mmkv = MMKV.defaultMMKV();
                    //保存
                    mmkv.encode("login",loginBean.getData());
                    //成功
                    iLoginView.onLoginSuccess();
                }else {
                    iLoginView.onLoginFail("获取登录数据失败"+loginBean.getMsg());
                }
            }

            @Override
            public void onFail(String error) {
                iLoginView.onLoginFail("获取登录数据失败"+error);
            }
        });
    }
}
