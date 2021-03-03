package com.example.doctorapp.choose.timer.contract;

import com.example.doctorapp.choose.timer.bean.DownBean;
import com.example.doctorapp.home.banner.bean.BannerBean;
import com.example.doctorapp.utils.ICallBack;

import okhttp3.RequestBody;

public class DownContract {
    //契约类 存放接口
    public interface iDownModel{

        <T> void getDownModel(String url, RequestBody requestBody, ICallBack<T> iCallBack);
    }

    public interface iDownPresenter{
        void getDown();
    }

    public interface iDownView{

        void onDownSuccess(DownBean downBean);

        void onDownFail(String error);
    }
}
