package com.example.doctorapp.choose.chooselist.presenter;

import com.example.doctorapp.choose.chooselist.contract.ChooseGradeContract;
import com.example.doctorapp.home.gradeclass.adapter.GradeListAdapter;
import com.example.doctorapp.home.gradeclass.bean.GradeClassBean;
import com.example.doctorapp.home.gradeclass.bean.GradeClassBodyBean;
import com.example.doctorapp.home.gradeclass.contract.GradeContract;
import com.example.doctorapp.home.gradeclass.model.GradeModel;
import com.example.doctorapp.utils.ICallBack;
import com.google.gson.Gson;

import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class ChooseClassPresenter implements ChooseGradeContract.iGradePresenter {
    private final GradeModel gradeModel;
    private GradeContract.iGradeView iGradeView;

    public ChooseClassPresenter(GradeContract.iGradeView iGradeView) {
        this.iGradeView = iGradeView;
        gradeModel = new GradeModel();
    }

    @Override
    public void getGradePresenter() {

        GradeClassBodyBean categoryBody = new GradeClassBodyBean();
        categoryBody.setType("0");
        categoryBody.setCategoryId1("1325280683323973633");
        categoryBody.setCategoryId2("1325641143281934337");

        Gson gson = new Gson();
        String str = gson.toJson(categoryBody);

        RequestBody body = RequestBody.create(MediaType.parse("application/json"),str);

        gradeModel.getFGradeModel("course/app/api/grade/list", body, new ICallBack<GradeClassBean>() {
            @Override
            public void onSuccess(GradeClassBean gradeClassBean) {
                //重新添加
                iGradeView.onSuccess(gradeClassBean);
            }

            @Override
            public void onFail(String error) {
                iGradeView.onFail("获取数据错误："+error);
            }
        });
    }
}
