package com.example.doctorapp.login.contract;

import android.util.Log;

import com.example.doctorapp.login.bean.LoginBean;
import com.example.doctorapp.utils.ICallBack;

import java.util.HashMap;

import okhttp3.RequestBody;

public class LoginContract {

    public interface iLoginPresenter{

        void getLoginPresenter(String model,String password);
    }

    public interface iLoginModel{
        <T> void getLoginModel(String url,RequestBody requestBody, ICallBack<T> iCallBack);
    }

    public interface iLoginView{
        void onLoginSuccess();

        void onLoginFail(String error);
    }
}
