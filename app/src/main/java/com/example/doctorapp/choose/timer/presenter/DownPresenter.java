package com.example.doctorapp.choose.timer.presenter;

import com.example.doctorapp.choose.timer.bean.DownBean;
import com.example.doctorapp.choose.timer.bean.DownBodyBean;
import com.example.doctorapp.choose.timer.contract.DownContract;
import com.example.doctorapp.choose.timer.model.DownModel;
import com.example.doctorapp.home.gradeclass.bean.GradeClassBodyBean;
import com.example.doctorapp.utils.ICallBack;
import com.google.gson.Gson;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class DownPresenter implements DownContract.iDownPresenter {
    private final DownModel downModel;
    private DownContract.iDownView iDownView;

    public DownPresenter(DownContract.iDownView iDownView) {
        this.iDownView = iDownView;
        downModel = new DownModel();
    }

    @Override
    public void getDown() {
        DownBodyBean downBodyBean = new DownBodyBean();
        downBodyBean.setCategoryId("1325634667888926721");

        Gson gson = new Gson();
        String str = gson.toJson(downBodyBean);

        RequestBody body = RequestBody.create(MediaType.parse("application/json"),str);

        downModel.getDownModel("course/api/count/down/view", body, new ICallBack<DownBean>() {
            @Override
            public void onSuccess(DownBean downBean) {
                if(downBean.getCode()==200){
                    iDownView.onDownSuccess(downBean);
                }else {
                    iDownView.onDownFail("失败"+downBean.getMsg());
                }
            }

            @Override
            public void onFail(String error) {
                iDownView.onDownFail("获取数据失败："+error);
            }
        });
    }
}
