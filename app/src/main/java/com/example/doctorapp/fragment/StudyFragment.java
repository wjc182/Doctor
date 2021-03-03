package com.example.doctorapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.doctorapp.R;
import com.example.doctorapp.activity.CacheActivity;


public class StudyFragment extends Fragment {


    private ImageView studyBanner;
    private ImageView studyClass;
    private TextView studyMyClass;
    private ImageView studyLive;
    private TextView myLive;
    private ImageView studyQuestion;
    private TextView myQuestion;
    private ImageView studyCache;
    private TextView myCache;
    private Button checkToClass;
    private FragmentActivity activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_study, container, false);
        activity = getActivity();
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        studyBanner =inflate.findViewById(R.id.study_banner);
        studyClass = inflate.findViewById(R.id.study_class);
        studyMyClass = inflate.findViewById(R.id.study_myClass);
        studyLive = inflate.findViewById(R.id.study_live);
        myLive = inflate.findViewById(R.id.my_live);
        studyQuestion = inflate.findViewById(R.id.study_question);
        myQuestion = inflate.findViewById(R.id.my_question);
        studyCache = inflate.findViewById(R.id.study_cache);
        myCache = inflate.findViewById(R.id.my_cache);
        checkToClass = inflate.findViewById(R.id.check_to_class);
        //缓存
        studyCache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, CacheActivity.class);
                startActivity(intent);
            }
        });
        //班级
        checkToClass.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "未做", Toast.LENGTH_SHORT).show();
            }
        });
    }
}