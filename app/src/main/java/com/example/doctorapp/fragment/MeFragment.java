package com.example.doctorapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.doctorapp.R;
import com.example.doctorapp.activity.LoginActivity;
import com.example.doctorapp.activity.MainActivity;
import com.example.doctorapp.login.bean.LoginBean;
import com.tencent.mmkv.MMKV;


public class MeFragment extends Fragment {


    private ImageView headImage;
    private TextView checkLogin;
    private ImageView studyImage;
    private ImageView callXingTan;
    private ImageView setUpImage;
    private FragmentActivity activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_me, container, false);
        activity = getActivity();
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        headImage =inflate.findViewById(R.id.head_image);
        checkLogin = inflate. findViewById(R.id.check_login);
        studyImage =inflate.findViewById(R.id.study_image);
        callXingTan = inflate.findViewById(R.id.call_XingTan);
        setUpImage = inflate.findViewById(R.id.set_up_image);


        //监听事件
        checkLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MMKV mmkv = MMKV.defaultMMKV();
                LoginBean.DataDTO token = mmkv.decodeParcelable("login", LoginBean.DataDTO.class);
                if(token==null){
                    startActivity(new Intent(activity, LoginActivity.class));
                }else {
                    startActivity(new Intent(activity, MainActivity.class));
                }
            }
        });

        //我的学习
        studyImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MMKV mmkv = MMKV.defaultMMKV();
                LoginBean.DataDTO token = mmkv.decodeParcelable("token", LoginBean.DataDTO.class);
                if(token==null){
                    startActivity(new Intent(activity, LoginActivity.class));
                }else {
                    startActivity(new Intent(activity, MainActivity.class));
                }
            }
        });
    }
}
