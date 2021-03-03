package com.example.doctorapp.home.homecategory.model;

import com.example.doctorapp.home.homecategory.contract.CategoryContract;
import com.example.doctorapp.utils.ICallBack;
import com.example.doctorapp.utils.NetWorkRetrofit;


import okhttp3.RequestBody;

public class CategoryModel implements CategoryContract.iCategoryModel {


    @Override
    public <T> void getCategoryModel(String url, RequestBody requestBody, ICallBack<T> iCallBack) {
        NetWorkRetrofit.getInstance().iRetrofitPost(url,requestBody,iCallBack);
    }
}
