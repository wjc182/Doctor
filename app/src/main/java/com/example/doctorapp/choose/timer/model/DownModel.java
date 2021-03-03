package com.example.doctorapp.choose.timer.model;

import com.example.doctorapp.choose.timer.contract.DownContract;
import com.example.doctorapp.utils.ICallBack;
import com.example.doctorapp.utils.NetWorkRetrofit;

import okhttp3.RequestBody;

public class DownModel implements DownContract.iDownModel {
    @Override
    public <T> void getDownModel(String url, RequestBody requestBody, ICallBack<T> iCallBack) {
        NetWorkRetrofit.getInstance().iRetrofitPost(url,requestBody,iCallBack);
    }
}
