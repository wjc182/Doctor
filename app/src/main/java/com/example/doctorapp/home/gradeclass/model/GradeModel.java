package com.example.doctorapp.home.gradeclass.model;

import com.example.doctorapp.home.gradeclass.contract.GradeContract;
import com.example.doctorapp.utils.ICallBack;
import com.example.doctorapp.utils.NetWorkRetrofit;

import okhttp3.RequestBody;

public class GradeModel implements GradeContract.iGradeModel {

    @Override
    public <T> void getFGradeModel(String url, RequestBody requestBody, ICallBack<T> iCallBack) {
        NetWorkRetrofit.getInstance().iRetrofitPost(url,requestBody,iCallBack);
    }
}