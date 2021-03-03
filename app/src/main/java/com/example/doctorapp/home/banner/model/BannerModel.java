package com.example.doctorapp.home.banner.model;

import com.example.doctorapp.home.banner.contract.BannerContract;
import com.example.doctorapp.utils.ICallBack;
import com.example.doctorapp.utils.NetWorkRetrofit;


import okhttp3.RequestBody;


public class BannerModel implements BannerContract.iBannerModel {

    @Override
    public <T> void getBannerModel(String url, RequestBody requestBody, ICallBack<T> iCallBack) {
        NetWorkRetrofit.getInstance().iRetrofitPost(url,requestBody,iCallBack);
    }
}
