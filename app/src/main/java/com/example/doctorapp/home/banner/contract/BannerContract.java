package com.example.doctorapp.home.banner.contract;

import com.example.doctorapp.home.banner.bean.BannerBean;
import com.example.doctorapp.utils.ICallBack;

import java.util.HashMap;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;


public class BannerContract {
    //契约类 存放接口
    public interface iBannerModel{

        <T> void getBannerModel(String url, RequestBody requestBody, ICallBack<T> iCallBack);
    }

    public interface iBannerPresenter{
        void getBanner();
    }

    public interface iBannerView{

        void onBannerSuccess(BannerBean bannerBean);

        void onBannerFail(String error);
    }
}
