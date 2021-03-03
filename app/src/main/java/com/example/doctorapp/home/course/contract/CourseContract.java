package com.example.doctorapp.home.course.contract;

import com.example.doctorapp.home.course.bean.CourseBean;
import com.example.doctorapp.home.gradeclass.bean.GradeClassBean;
import com.example.doctorapp.utils.ICallBack;

import okhttp3.RequestBody;

public class CourseContract {

    public interface iCoursePresenter{
       void getCoursePresenter();

    }

    public interface iCourseModel{
        <T> void getCourseModel(String url, RequestBody requestBody, ICallBack<T> iCallBack);
    }


    public interface iCourseView{
        void onSuccess(CourseBean courseBean);


        void onFail(String error);
    }
}
