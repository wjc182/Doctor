package com.example.doctorapp.choose.bookpic.presenter;

import com.example.doctorapp.choose.bookpic.bean.ChooseBookBean;
import com.example.doctorapp.choose.bookpic.bean.ChooseBookBodyBean;
import com.example.doctorapp.choose.bookpic.contract.ChooseBookContract;
import com.example.doctorapp.choose.bookpic.model.ChooseBookModel;
import com.example.doctorapp.utils.ICallBack;
import com.google.gson.Gson;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class ChooseBookPresenter implements ChooseBookContract.iChooseBookPresenter {
    private final ChooseBookModel chooseBookModel;
    private ChooseBookContract.iChooseBookView iChooseBookView;

    public ChooseBookPresenter(ChooseBookContract.iChooseBookView iChooseBookView) {
        this.iChooseBookView = iChooseBookView;
        chooseBookModel = new ChooseBookModel();
    }

    @Override
    public void getBookPresenter() {
        ChooseBookBodyBean chooseBookBodyBean = new ChooseBookBodyBean();
        chooseBookBodyBean.setType("1");
        //gson
        Gson gson = new Gson();
        String json = gson.toJson(chooseBookBodyBean);
        RequestBody body = RequestBody.create(MediaType.parse("application/json"),json);

        chooseBookModel.getBookModel("course/app/api/pic/list", body, new ICallBack<ChooseBookBean>() {
            @Override
            public void onSuccess(ChooseBookBean chooseBookBean) {
                if(chooseBookBean.getCode()==200){
                    iChooseBookView.onBookSuccess(chooseBookBean);
                }else {
                    iChooseBookView.onBookFail("数据错误："+chooseBookBean.getMsg());
                }
            }

            @Override
            public void onFail(String error) {
                iChooseBookView.onBookFail("数据错误："+error);
            }
        });

    }
}
