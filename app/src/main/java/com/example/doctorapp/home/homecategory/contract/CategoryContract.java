package com.example.doctorapp.home.homecategory.contract;

import com.example.doctorapp.home.homecategory.bean.CategoryBean;
import com.example.doctorapp.utils.ICallBack;

import okhttp3.RequestBody;

public class CategoryContract {

    public interface  iCategoryModel{
        <T> void getCategoryModel(String url, RequestBody requestBody, ICallBack<T> iCallBack);
    }

    public interface iCategoryPresenter{
        void getCategoryModel();
    }

    public interface iCategoryView{

        void onSuccess(CategoryBean categoryBean);

        void onFail(String error);
    }

}
