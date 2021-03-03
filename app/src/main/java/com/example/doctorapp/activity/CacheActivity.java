package com.example.doctorapp.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.doctorapp.R;
import com.example.doctorapp.cache.adapter.CaCheVapAdapter;
import com.example.doctorapp.cache.fragment.LoadFinshFragment;
import com.example.doctorapp.cache.fragment.LoadFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class CacheActivity extends AppCompatActivity {

    private TabLayout cacheLoadTab;
    private ViewPager cacheLoadVap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cache);
        initView();
    }

    private void initView() {
        cacheLoadTab = (TabLayout) findViewById(R.id.cache_load_tab);
        cacheLoadVap = (ViewPager) findViewById(R.id.cache_load_vap);
        //fragment
        LoadFragment loadFragment = new LoadFragment();
        LoadFinshFragment loadFinshFragment = new LoadFinshFragment();

        //集合
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(loadFragment);
        list.add(loadFinshFragment);
        //适配器
        CaCheVapAdapter caCheVapAdapter = new CaCheVapAdapter(getSupportFragmentManager(), list);
        //绑定适配器
        cacheLoadVap.setAdapter(caCheVapAdapter);
        cacheLoadTab.setupWithViewPager(cacheLoadVap);
        cacheLoadTab.getTabAt(0).setText("已下载");
        cacheLoadTab.getTabAt(1).setText("下载中");
    }
}