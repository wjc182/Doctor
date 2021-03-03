package com.example.doctorapp.home.course.model;

import com.example.doctorapp.home.course.contract.CourseContract;
import com.example.doctorapp.utils.ICallBack;
import com.example.doctorapp.utils.NetWorkRetrofit;

import okhttp3.RequestBody;

public class CourseModel implements CourseContract.iCourseModel {

    @Override
    public <T> void getCourseModel(String url, RequestBody requestBody, ICallBack<T> iCallBack) {
        NetWorkRetrofit.getInstance().iRetrofitPost(url,requestBody,iCallBack);
    }
}
