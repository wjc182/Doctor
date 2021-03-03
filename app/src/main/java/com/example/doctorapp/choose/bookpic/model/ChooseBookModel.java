package com.example.doctorapp.choose.bookpic.model;

import com.example.doctorapp.choose.bookpic.contract.ChooseBookContract;
import com.example.doctorapp.utils.ICallBack;
import com.example.doctorapp.utils.NetWorkRetrofit;

import okhttp3.RequestBody;

public class ChooseBookModel implements ChooseBookContract.iChooseBookModel {
    @Override
    public <T> void getBookModel(String url, RequestBody requestBody, ICallBack<T> iCallBack) {
        NetWorkRetrofit.getInstance().iRetrofitPost(url,requestBody,iCallBack);

    }





}
