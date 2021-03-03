package com.example.doctorapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.doctorapp.R;
import com.example.doctorapp.buy.adapter.BuyAdapter;
import com.example.doctorapp.buy.fragment.BuyClassJIanJieFragment;
import com.example.doctorapp.buy.fragment.BuyClassListFragment;
import com.example.doctorapp.home.gradeclass.bean.GradeClassBean;
import com.google.android.material.tabs.TabLayout;

import java.io.Serializable;
import java.util.ArrayList;

public class HomeBuyActivity extends AppCompatActivity {

    private ImageView buyImage;
    private TextView buyName;
    private TabLayout buyTab;
    private ViewPager buyVap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_buy);
        initView();
    }

    private void initView() {
        buyImage = (ImageView) findViewById(R.id.buy_image);
        buyName = (TextView) findViewById(R.id.buy_name);
        buyTab = (TabLayout) findViewById(R.id.buy_tab);
        buyVap = (ViewPager) findViewById(R.id.buy_vap);

        Intent intent = getIntent();
        GradeClassBean.DataBean.CourseGradeListBean  list = (GradeClassBean.DataBean.CourseGradeListBean) intent.getSerializableExtra("list");
        buyName.setText(list.getGradeName());
        Glide.with(this).load(list.getClassLogo()).into(buyImage);

        BuyClassListFragment buyClassListFragment = new BuyClassListFragment();
        BuyClassJIanJieFragment buyClassJIanJieFragment = new BuyClassJIanJieFragment();
        ArrayList<Fragment> arrayList = new ArrayList<>();
        arrayList.add(buyClassListFragment);
        arrayList.add(buyClassJIanJieFragment);
        BuyAdapter buyAdapter = new BuyAdapter(getSupportFragmentManager(), arrayList);
        buyVap.setAdapter(buyAdapter);
        buyTab.setupWithViewPager(buyVap);
        buyTab.getTabAt(0).setText("课程列表");
        buyTab.getTabAt(1).setText("课程简介");
    }
}