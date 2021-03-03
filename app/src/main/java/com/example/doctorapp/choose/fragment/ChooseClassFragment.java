package com.example.doctorapp.choose.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.doctorapp.R;
import com.example.doctorapp.activity.HomeBuyActivity;
import com.example.doctorapp.activity.LoginActivity;
import com.example.doctorapp.choose.chooselist.adapter.ChooseClassListAdapter;
import com.example.doctorapp.choose.chooselist.presenter.ChooseClassPresenter;
import com.example.doctorapp.home.gradeclass.bean.GradeClassBean;
import com.example.doctorapp.home.gradeclass.contract.GradeContract;
import com.example.doctorapp.login.bean.LoginBean;
import com.tencent.mmkv.MMKV;

import java.util.ArrayList;
import java.util.List;

public class ChooseClassFragment extends Fragment implements GradeContract.iGradeView {

    private FragmentActivity activity;


    private ArrayList<GradeClassBean.DataBean.CourseGradeListBean> list;
    private ChooseClassListAdapter chooseClassListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_choose_class, container, false);
        activity = getActivity();
        initView(inflate);
        //准备数据
        initData();
        //监听事件
        initListener();
        return inflate;
    }

    private void initListener() {
        chooseClassListAdapter.setClassListener(new ChooseClassListAdapter.ClassListener() {
            @Override
            public void itemListener(int pos) {
                //初始化MMKV
                MMKV mmkv = MMKV.defaultMMKV();
                //获取Token
                LoginBean.DataDTO login = mmkv.decodeParcelable("login", LoginBean.DataDTO.class);
                //判断Token是否为空
                if(login==null){
                    startActivity(new Intent(activity, LoginActivity.class));
                }else {
                    Intent intent = new Intent(activity, HomeBuyActivity.class);
                    GradeClassBean.DataBean.CourseGradeListBean listBean = list.get(pos);
                    intent.putExtra("list",listBean);
                    startActivity(intent);
                }
            }
        });
    }

    private void initData() {
        //热门课程
        ChooseClassPresenter gradePresenter = new ChooseClassPresenter(this);
        gradePresenter.getGradePresenter();
    }

    private void initView(View inflate) {

        RecyclerView recyclerView = inflate.findViewById(R.id.choose_class_rec);
        //布局
        recyclerView.setLayoutManager(new GridLayoutManager(activity,2));
        //集合
        list = new ArrayList<>();
        //适配器
        chooseClassListAdapter = new ChooseClassListAdapter(activity, list);
        recyclerView.setAdapter(chooseClassListAdapter);
    }

    @Override
    public void onSuccess(GradeClassBean gradeClassBean) {
        List<GradeClassBean.DataBean.CourseGradeListBean> courseGradeList = gradeClassBean.getData().getCourseGradeList();
        list.addAll(courseGradeList);
        chooseClassListAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String error) {
        Log.e("TAG",error);
    }
}