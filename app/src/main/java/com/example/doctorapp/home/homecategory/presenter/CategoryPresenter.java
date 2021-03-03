package com.example.doctorapp.home.homecategory.presenter;

import com.example.doctorapp.home.banner.bean.HomeBannerBody;
import com.example.doctorapp.home.homecategory.bean.CategoryBean;
import com.example.doctorapp.home.homecategory.bean.CategoryBody;
import com.example.doctorapp.home.homecategory.contract.CategoryContract;
import com.example.doctorapp.home.homecategory.model.CategoryModel;
import com.example.doctorapp.utils.ICallBack;
import com.google.gson.Gson;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class CategoryPresenter implements CategoryContract.iCategoryPresenter {
    private final CategoryModel categoryModel;
    private CategoryContract.iCategoryView categoryView;

    public CategoryPresenter(CategoryContract.iCategoryView categoryView) {
        this.categoryView = categoryView;
        categoryModel = new CategoryModel();
    }

    @Override
    public void getCategoryModel() {

        CategoryBody categoryBody = new CategoryBody();
        categoryBody.setCategoryType("2");

        Gson gson = new Gson();
        String str = gson.toJson(categoryBody);

        RequestBody body = RequestBody.create(MediaType.parse("application/json"),str);

        categoryModel.getCategoryModel("course/api/course/category/list", body, new ICallBack<CategoryBean>() {
            @Override
            public void onSuccess(CategoryBean categoryBean) {
                categoryView.onSuccess(categoryBean);
            }

            @Override
            public void onFail(String error) {
                categoryView.onFail("课程数据获取错误："+error);
            }
        });
    }
}
