package com.example.doctorapp.choose.fragment;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.doctorapp.R;
import com.example.doctorapp.choose.bookpic.adapter.ChooseBookAdapter;
import com.example.doctorapp.choose.bookpic.bean.ChooseBookBean;
import com.example.doctorapp.choose.bookpic.contract.ChooseBookContract;
import com.example.doctorapp.choose.bookpic.presenter.ChooseBookPresenter;

import java.util.ArrayList;

public class ChooseBookFragment extends Fragment implements ChooseBookContract.iChooseBookView {


    private FragmentActivity activity;
    private RecyclerView rec;
    private ArrayList<ChooseBookBean.DataDTO> list;
    private ChooseBookAdapter chooseBookAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_choose_book, container, false);
        activity = getActivity();
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        //准备数据\
        ChooseBookPresenter chooseBookPresenter = new ChooseBookPresenter(this);
        chooseBookPresenter.getBookPresenter();
    }

    private void initView(View inflate) {
        rec = inflate.findViewById(R.id.choose_book_rec);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        rec.setLayoutManager(linearLayoutManager);
        //集合
        list = new ArrayList<>();
        //适配器
        chooseBookAdapter = new ChooseBookAdapter(activity,list);
        rec.setAdapter(chooseBookAdapter);
    }

    @Override
    public void onBookSuccess(ChooseBookBean chooseBookBean) {
        ChooseBookBean.DataDTO data = chooseBookBean.getData();
        list.add(data);
        //刷新适配器
        chooseBookAdapter.notifyDataSetChanged();
    }

    @Override
    public void onBookFail(String error) {

    }
}