package com.example.doctorapp.home.banner.presenter;

import android.util.Log;

import com.example.doctorapp.home.banner.bean.BannerBean;
import com.example.doctorapp.home.banner.bean.HomeBannerBody;
import com.example.doctorapp.home.banner.contract.BannerContract;
import com.example.doctorapp.home.banner.model.BannerModel;
import com.example.doctorapp.utils.ICallBack;
import com.google.gson.Gson;
import com.youth.banner.Banner;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class BannerPresenter implements BannerContract.iBannerPresenter {
    private final BannerModel bannerModel;
    private BannerContract.iBannerView bannerView;

    public BannerPresenter(BannerContract.iBannerView bannerView) {
        this.bannerView = bannerView;
        bannerModel = new BannerModel();
    }

    @Override
    public void getBanner() {

        HomeBannerBody bannerBody = new HomeBannerBody();
        bannerBody.setAdvLocation("7");
        bannerBody.setPlatShow("0");

        Gson gson = new Gson();
        String str = gson.toJson(bannerBody);

        RequestBody body = RequestBody.create(MediaType.parse("application/json"),str);

        bannerModel.getBannerModel("course/api/adv/list", body,new ICallBack<BannerBean>() {
            @Override
            public void onSuccess(BannerBean bannerBean) {
                bannerView.onBannerSuccess(bannerBean);
            }

            @Override
            public void onFail(String error) {

                bannerView.onBannerFail("请求banner数据失败："+error);
            }
        });
    }
}
