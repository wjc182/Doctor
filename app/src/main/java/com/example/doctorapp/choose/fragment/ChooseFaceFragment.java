package com.example.doctorapp.choose.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.doctorapp.R;
import com.example.doctorapp.choose.bookpic.adapter.ChooseBookAdapter;
import com.example.doctorapp.choose.bookpic.bean.ChooseBookBean;
import com.example.doctorapp.choose.bookpic.contract.ChooseBookContract;
import com.example.doctorapp.choose.bookpic.presenter.ChooseBookPresenter;
import com.example.doctorapp.choose.chooseface.presenter.ChooseFacePresenter;

import java.util.ArrayList;


public class ChooseFaceFragment extends Fragment implements ChooseBookContract.iChooseBookView {

    private FragmentActivity activity;
    private ArrayList<ChooseBookBean.DataDTO> dataDTOS;
    private ChooseBookAdapter chooseBookAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_choose_face, container, false);
        activity = getActivity();
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        ChooseFacePresenter chooseFacePresenter = new ChooseFacePresenter(this);
        chooseFacePresenter.getBookPresenter();
    }

    private void initView(View inflate) {
        RecyclerView recyclerView = inflate.findViewById(R.id.choose_face_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        dataDTOS = new ArrayList<>();
        chooseBookAdapter = new ChooseBookAdapter(activity, dataDTOS);
        recyclerView.setAdapter(chooseBookAdapter);
    }

    @Override
    public void onBookSuccess(ChooseBookBean chooseBookBean) {
        ChooseBookBean.DataDTO data = chooseBookBean.getData();
        dataDTOS.add(data);
        chooseBookAdapter.notifyDataSetChanged();
    }

    @Override
    public void onBookFail(String error) {

    }
}