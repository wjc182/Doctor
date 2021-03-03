package com.example.doctorapp.choose.chooselist.doctor.contract;

import com.example.doctorapp.home.course.bean.CourseBean;
import com.example.doctorapp.utils.ICallBack;

import okhttp3.RequestBody;

public class DoctorCourseContract {

    public interface iCoursePresenter{
       void getCoursePresenter(int id);

    }

    public interface iCourseModel{
        <T> void getCourseModel(String url, RequestBody requestBody, ICallBack<T> iCallBack);
    }


    public interface iCourseView{
        void onSuccess(CourseBean courseBean);


        void onFail(String error);
    }
}
