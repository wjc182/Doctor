package com.example.doctorapp.choose.chooselist.doctor.presenter;

import android.util.Log;

import com.example.doctorapp.choose.chooselist.doctor.contract.DoctorCourseContract;
import com.example.doctorapp.home.course.bean.CourseBean;
import com.example.doctorapp.home.course.bean.CourseBodyBean;
import com.example.doctorapp.home.course.contract.CourseContract;
import com.example.doctorapp.home.course.model.CourseModel;
import com.example.doctorapp.utils.ICallBack;
import com.google.gson.Gson;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class DoctorCoursePresenter implements DoctorCourseContract.iCoursePresenter {
    private final CourseModel courseModel;
    private CourseContract.iCourseView iCourseView;

    public DoctorCoursePresenter(CourseContract.iCourseView iCourseView) {
        this.iCourseView = iCourseView;
        courseModel = new CourseModel();
    }

    @Override
    public void getCoursePresenter(int id) {
        CourseBodyBean categoryBody = new CourseBodyBean();
        categoryBody.setCategoryType("0");

        Gson gson = new Gson();
        String str = gson.toJson(categoryBody);

        RequestBody body = RequestBody.create(MediaType.parse("application/json"),str);


        courseModel.getCourseModel("course/app/api/course/category/list", body, new ICallBack<CourseBean>() {
            @Override
            public void onSuccess(CourseBean courseBean) {
                if (courseBean.getCode()==200){
                    iCourseView.onSuccess(courseBean);
                }else {
                    Log.e("TAG", "课程数据请求失败: "+courseBean.getMsg() );
                }
            }

            @Override
            public void onFail(String error) {
                iCourseView.onFail("课程数据"+error);
            }
        });
    }
}
