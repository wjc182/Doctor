package com.example.doctorapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.doctorapp.R;
import com.example.doctorapp.guide.GuideAdapter;

import java.util.ArrayList;

public class GuideActivity extends AppCompatActivity {

    private ViewPager guideMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
    }

    private void initView() {
        guideMain = (ViewPager) findViewById(R.id.guide_main);
        //控件
        LayoutInflater inflater = LayoutInflater.from(this);
        View view1 = inflater.inflate(R.layout.guide_view1, null);
        View view2 = inflater.inflate(R.layout.guide_view2, null);
        View view3 = inflater.inflate(R.layout.guide_view3, null);
        View view4 = inflater.inflate(R.layout.guide_view4, null);
        //跳过监听
        TextView jump = view4.findViewById(R.id.jump);
        //lambda
        jump.setOnClickListener(v -> {
            //跳转
            startActivity(new Intent(GuideActivity.this,MainActivity.class));
        });

        //集合
        ArrayList<View> list = new ArrayList<>();
        list.add(view1);
        list.add(view2);
        list.add(view3);
        list.add(view4);
        //适配器
        GuideAdapter guideAdapter = new GuideAdapter(list);
        //设置适配器
        guideMain.setAdapter(guideAdapter);
    }
}