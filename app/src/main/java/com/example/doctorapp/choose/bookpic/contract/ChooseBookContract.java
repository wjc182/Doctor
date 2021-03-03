package com.example.doctorapp.choose.bookpic.contract;

import com.example.doctorapp.choose.bookpic.bean.ChooseBookBean;
import com.example.doctorapp.utils.ICallBack;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;

public class ChooseBookContract {
    public interface iChooseBookPresenter{
        void getBookPresenter();
    }
    public interface iChooseBookModel{
        <T> void getBookModel(String url, RequestBody requestBody, ICallBack<T> iCallBack);
    }
    public interface iChooseBookView{
        void onBookSuccess(ChooseBookBean chooseBookBean);

        void onBookFail(String error);
    }
}
