package com.example.doctorapp.login.model;

import com.example.doctorapp.login.contract.LoginContract;
import com.example.doctorapp.utils.ICallBack;
import com.example.doctorapp.utils.NetWorkRetrofit;

import java.util.HashMap;

import okhttp3.RequestBody;

public class LoginModel implements LoginContract.iLoginModel {

    @Override
    public <T> void getLoginModel(String url, RequestBody requestBody, ICallBack<T> iCallBack) {
        NetWorkRetrofit.getInstance().iRetrofitPostLogin(url,requestBody,iCallBack);
    }
}
