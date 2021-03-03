package com.example.doctorapp.home.gradeclass.contract;

import com.example.doctorapp.home.gradeclass.adapter.GradeListAdapter;
import com.example.doctorapp.home.gradeclass.bean.GradeClassBean;
import com.example.doctorapp.utils.ICallBack;

import java.util.ArrayList;

import okhttp3.RequestBody;

public class GradeContract {
    public interface iGradePresenter{
        void getGradePresenter(String id1, String id2, ArrayList<GradeClassBean.DataBean.CourseGradeListBean> listBeans, GradeListAdapter gradeListAdapter);
    }

    public interface iGradeModel{
        <T> void getFGradeModel(String url, RequestBody requestBody, ICallBack<T> iCallBack);
    }

    public interface iGradeView{
        void onSuccess(GradeClassBean gradeClassBean);

        void onFail(String error);

    }
}
