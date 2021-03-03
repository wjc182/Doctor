package com.example.doctorapp.utils;

public interface ICallBack<T> {
    //接口
    void onSuccess(T t);

    void onFail(String error);
}
