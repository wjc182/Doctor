package com.example.doctorapp.choose.chooselist.contract;

import com.example.doctorapp.home.gradeclass.adapter.GradeListAdapter;
import com.example.doctorapp.home.gradeclass.bean.GradeClassBean;
import com.example.doctorapp.utils.ICallBack;

import java.util.ArrayList;

import okhttp3.RequestBody;

public class ChooseGradeContract {
    public interface iGradePresenter{
        void getGradePresenter();
    }

    public interface iGradeModel{
        <T> void getFGradeModel(String url, RequestBody requestBody, ICallBack<T> iCallBack);
    }

    public interface iGradeView{
        void onSuccess(GradeClassBean gradeClassBean);

        void onFail(String error);

    }
}
