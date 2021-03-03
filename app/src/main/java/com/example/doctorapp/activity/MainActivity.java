package com.example.doctorapp.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.doctorapp.R;
import com.example.doctorapp.fragment.BlankFragment;
import com.example.doctorapp.fragment.ChooseFragment;
import com.example.doctorapp.fragment.HomeFragment;
import com.example.doctorapp.fragment.MeFragment;
import com.example.doctorapp.fragment.StudyFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private FrameLayout frameMain;
    private TabLayout tabMain;
    private FragmentManager supportFragmentManager;
    private HomeFragment homeFragment;
   // private QuestionFragment questionFragment;
    private ChooseFragment chooseFragment;
    private StudyFragment studyFragment;
    private MeFragment meFragment;
    private ImageView contactTeacher;
    private BlankFragment blankFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        frameMain = (FrameLayout) findViewById(R.id.frame_main);
        tabMain = (TabLayout) findViewById(R.id.tab_main);

        //fragment
        homeFragment = new HomeFragment();
        //questionFragment = new QuestionFragment();
        chooseFragment = new ChooseFragment();
        studyFragment = new StudyFragment();
        meFragment = new MeFragment();
        blankFragment = new BlankFragment();

        //事务管理器
        supportFragmentManager = getSupportFragmentManager();

        supportFragmentManager.beginTransaction()
                .add(R.id.frame_main, homeFragment)
                .add(R.id.frame_main, chooseFragment)
                .add(R.id.frame_main, studyFragment)
                .add(R.id.frame_main, meFragment)
                .add(R.id.frame_main,blankFragment)
                .hide(blankFragment)
                .hide(chooseFragment)
                .hide(studyFragment)
                .hide(meFragment)
                .commit();

        //接口回调
        homeFragment.setItemFragmentEvent(new HomeFragment.ItemFragmentEvent() {
            @Override
            public void itemFragment() {
                supportFragmentManager.beginTransaction()
                        .hide(homeFragment)
                        .hide(blankFragment)
                        .show(chooseFragment)
                        .hide(studyFragment)
                        .hide(meFragment)
                        .commit();
                //默认选中
                tabMain.getTabAt(2).select();
            }
        });

        tabMain.addTab(tabMain.newTab().setText("首页").setIcon(R.drawable.home_lcon));
        tabMain.addTab(tabMain.newTab().setText("题库").setIcon(R.drawable.ti_lcon));
        tabMain.addTab(tabMain.newTab().setText("选课").setIcon(R.drawable.class_lcon));
        tabMain.addTab(tabMain.newTab().setText("学习").setIcon(R.drawable.book_lcon));
        tabMain.addTab(tabMain.newTab().setText("我的").setIcon(R.drawable.me_lcon));

        tabMain.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {

                    case 0:
                        supportFragmentManager.beginTransaction()
                                .show(homeFragment)
                                .hide(blankFragment)
                                .hide(chooseFragment)
                                .hide(studyFragment)
                                .hide(meFragment)
                                .commit();

                        break;
                    case 1:
                        supportFragmentManager.beginTransaction()
                                .hide(homeFragment)
                                .show(blankFragment)
                                .hide(chooseFragment)
                                .hide(studyFragment)
                                .hide(meFragment)
                                .commit();

                        break;
                    case 2:
                        supportFragmentManager.beginTransaction()
                                .hide(homeFragment)
                                .hide(blankFragment)
                                .show(chooseFragment)
                                .hide(studyFragment)
                                .hide(meFragment)
                                .commit();

                        break;
                    case 3:
                        supportFragmentManager.beginTransaction()
                                .hide(homeFragment)
                                .hide(blankFragment)
                                .hide(chooseFragment)
                                .show(studyFragment)
                                .hide(meFragment)
                                .commit();

                        break;
                    case 4:
                        supportFragmentManager.beginTransaction()
                                .hide(homeFragment)
                                .hide(blankFragment)
                                .hide(chooseFragment)
                                .hide(studyFragment)
                                .show(meFragment)
                                .commit();
                        break;

                }


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        //联系老师
        contactTeacher = (ImageView) findViewById(R.id.contact_teacher);
        contactTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "联系老师", Toast.LENGTH_SHORT).show();
            }
        });
    }
}