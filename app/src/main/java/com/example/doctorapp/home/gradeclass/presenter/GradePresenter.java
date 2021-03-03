package com.example.doctorapp.home.gradeclass.presenter;

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

public class GradePresenter implements GradeContract.iGradePresenter {
    private final GradeModel gradeModel;
    private GradeContract.iGradeView iGradeView;

    public GradePresenter(GradeContract.iGradeView iGradeView) {
        this.iGradeView = iGradeView;
        gradeModel = new GradeModel();
    }

    @Override
    public void getGradePresenter(String id1, String id2, ArrayList<GradeClassBean.DataBean.CourseGradeListBean> listBeans, GradeListAdapter gradeListAdapter) {

        GradeClassBodyBean categoryBody = new GradeClassBodyBean();
        categoryBody.setType("0");
        categoryBody.setCategoryId1(id1);
        categoryBody.setCategoryId2(id2);

        Gson gson = new Gson();
        String str = gson.toJson(categoryBody);

        RequestBody body = RequestBody.create(MediaType.parse("application/json"),str);

        gradeModel.getFGradeModel("course/app/api/grade/list", body, new ICallBack<GradeClassBean>() {
            @Override
            public void onSuccess(GradeClassBean gradeClassBean) {
                //重新添加
                listBeans.clear();
                listBeans.addAll(gradeClassBean.getData().getCourseGradeList());
                gradeListAdapter.notifyDataSetChanged();
                //成功的数据
                iGradeView.onSuccess(gradeClassBean);
            }

            @Override
            public void onFail(String error) {
                iGradeView.onFail("获取数据错误："+error);
            }
        });
    }
}
