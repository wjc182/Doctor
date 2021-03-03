package com.example.doctorapp.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.doctorapp.R;
import com.example.doctorapp.choose.chooselist.adapter.ChooseListAdapter;
import com.example.doctorapp.choose.fragment.ChooseBookFragment;
import com.example.doctorapp.choose.fragment.ChooseClassFragment;
import com.example.doctorapp.choose.fragment.ChooseFaceFragment;
import com.example.doctorapp.choose.fragment.ChooseVideoFragment;
import com.example.doctorapp.choose.timer.bean.DownBean;
import com.example.doctorapp.choose.timer.contract.DownContract;
import com.example.doctorapp.choose.timer.presenter.DownPresenter;
import com.example.doctorapp.home.banner.bean.BannerBean;
import com.example.doctorapp.home.banner.contract.BannerContract;
import com.example.doctorapp.home.banner.presenter.BannerPresenter;
import com.example.doctorapp.home.course.adapter.CourseListAdapter;
import com.example.doctorapp.home.course.bean.CourseBean;
import com.example.doctorapp.home.course.contract.CourseContract;
import com.example.doctorapp.home.course.presenter.CoursePresenter;
import com.example.doctorapp.home.homecategory.bean.CategoryBean;
import com.example.doctorapp.home.homecategory.contract.CategoryContract;
import com.example.doctorapp.home.homecategory.presenter.CategoryPresenter;
import com.google.android.material.tabs.TabLayout;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class ChooseFragment extends Fragment implements DownContract.iDownView, BannerContract.iBannerView, CourseContract.iCourseView {


    private FragmentActivity activity;
    private TextView timer;
    private Banner chooseBanner;
    private ArrayList<BannerBean.DataDTO.AdvListDTO> bannerList;
    private RecyclerView chooseRew;
    private TabLayout tabChoose;
    private ViewPager vapChoose;
    private ArrayList<CourseBean.DataDTO.CourseCategoryListDTO.SubListDTO> subListDTOS;
    private CourseListAdapter adapter;
    private ChooseListAdapter chooseListAdapter;
    private TextView doctor;

    private CoursePresenter coursePresenter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_choose, container, false);
        activity = getActivity();
        initView(view);
        //准备资源
        initData();
        //监听
        initListener();
        return view;
    }

    private void initListener() {
        adapter.setItemListener(new CourseListAdapter.ItemListener() {
            @Override
            public void itemClick(int pos) {
                Toast.makeText(activity, "未做", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initData() {
        //倒计时
        DownPresenter downPresenter = new DownPresenter(this);
        downPresenter.getDown();
        //banner
        BannerPresenter bannerPresenter = new BannerPresenter(this);
        bannerPresenter.getBanner();
        //rew列表
        //课程
        coursePresenter = new CoursePresenter(this);
        coursePresenter.getCoursePresenter();

    }

    private void initView(View view) {
        timer = view.findViewById(R.id.timer);
        chooseBanner = view.findViewById(R.id.choose_banner);
        chooseRew = view.findViewById(R.id.choose_rew);
        tabChoose = view.findViewById(R.id.tab_choose);
        vapChoose = view.findViewById(R.id.vap_choose);
        doctor = view.findViewById(R.id.choose_doctor);

        //rec布局管理
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(activity);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        chooseRew.setLayoutManager(linearLayoutManager);
        //集合
        subListDTOS = new ArrayList<>();
        //适配器
        adapter = new CourseListAdapter(activity, subListDTOS);
        chooseRew.setAdapter(adapter);

        ChooseClassFragment chooseClassFragment = new ChooseClassFragment();
        ChooseVideoFragment chooseVideoFragment = new ChooseVideoFragment();
        ChooseBookFragment chooseBookFragment = new ChooseBookFragment();
        ChooseFaceFragment chooseFaceFragment = new ChooseFaceFragment();
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(chooseClassFragment);
        list.add(chooseVideoFragment);
        list.add(chooseBookFragment);
        list.add(chooseFaceFragment);
        //适配器
        chooseListAdapter = new ChooseListAdapter(getFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,list);
        vapChoose.setAdapter(chooseListAdapter);
        tabChoose.setupWithViewPager(vapChoose);
        tabChoose.getTabAt(0).setText("热门班级").setIcon(R.drawable.ic_hot_class);
        tabChoose.getTabAt(1).setText("直播课程").setIcon(R.drawable.ic_live);
        tabChoose.getTabAt(2).setText("配套书籍").setIcon(R.drawable.ic_book);
        tabChoose.getTabAt(3).setText("面授集训").setIcon(R.drawable.ic_face_to_face);

        //获取id
        SharedPreferences sharedPreferences = activity.getSharedPreferences("name", Context.MODE_PRIVATE);
        //获取
        String id1 = sharedPreferences.getString("id1", "");
        String id2 = sharedPreferences.getString("id2", "");

        Log.e("ID",id1);
        Log.e("ID",id2);
        doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //popuWindown
                View inflate = LayoutInflater.from(activity).inflate(R.layout.choose_popu_item, null);
                //找控件
                TextView zhiye_doctor = inflate.findViewById(R.id.zhiye_doctor);
                TextView zhiye_yaoshi = inflate.findViewById(R.id.zhiye_yaoshi);
                TextView jiankang_doctor = inflate.findViewById(R.id.jiankang_doctor);
                TextView zhicheng_doctor = inflate.findViewById(R.id.zhicheng_doctor);
                TextView china_doctor = inflate.findViewById(R.id.china_doctor);
                TextView xueli_tisheng = inflate.findViewById(R.id.xueli_tisheng);
                TextView jineng_peixun = inflate.findViewById(R.id.jineng_peixun);

                //弹窗
                PopupWindow popupWindow = new PopupWindow(inflate,ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                popupWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                popupWindow.setOutsideTouchable(true);
                //位置
                popupWindow.showAtLocation(doctor, Gravity.CENTER,0,0);
                //色差
                WindowManager.LayoutParams lp=activity.getWindow().getAttributes();
                lp.alpha=0.3f;
                activity.getWindow().setAttributes(lp);
                //空白位置关闭
                popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        WindowManager.LayoutParams lp=activity.getWindow().getAttributes();
                        lp.alpha=1;
                        activity.getWindow().setAttributes(lp);
                        popupWindow.dismiss();
                    }
                });

                //医师监听
                zhiye_doctor.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        doctor.setText(zhiye_doctor.getText().toString());
                        popupWindow.dismiss();
                    }
                });
                //药师
                zhiye_yaoshi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        doctor.setText(zhiye_yaoshi.getText().toString());
                        popupWindow.dismiss();
                    }
                });
                //健康管理师
                jiankang_doctor.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        doctor.setText(jiankang_doctor.getText().toString());
                        popupWindow.dismiss();
                    }
                });
                //职称药师
                zhicheng_doctor.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        doctor.setText(zhicheng_doctor.getText().toString());
                        popupWindow.dismiss();
                    }
                });
                //中医专长
                china_doctor.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        doctor.setText(china_doctor.getText().toString());
                        popupWindow.dismiss();
                    }
                });
                //学历提升
                xueli_tisheng.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        doctor.setText(xueli_tisheng.getText().toString());
                        popupWindow.dismiss();
                    }
                });
                //技能培训
                jineng_peixun.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        doctor.setText(jineng_peixun.getText().toString());
                        popupWindow.dismiss();
                    }
                });
            }
        });
    }

    //倒计时
    @Override
    public void onDownSuccess(DownBean downBean) {
       // 规定日期的格式
        SimpleDateFormat formater1=new SimpleDateFormat("yyyy-MM-dd");
        String date1= downBean.getData().getEndIncidentTime();  //获取结束时间
        Calendar cal= Calendar.getInstance();
        /**
         * 获取现在的年月日
         */
        String date2=cal.get(Calendar.YEAR)+"-"
                +(cal.get(Calendar.MONTH)+1)+"-"
                +cal.get(Calendar.DATE);
        // try里的日期是不能在下面直接用的，所以定义一个，当成功的情况传给day1
        long day1=0;
        // 转化格式使用parse，但是需要try，catch一下
        try {
            Date d1 = formater1.parse(date1);// 转化第一个字符串为日期格式
            Date d2=formater1.parse(date2);// 转化第二个字符串为日期格式
            long days=(d1.getTime()-d2.getTime())/24/60/60/1000;
            day1=days;
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        timer.setText("考试倒计时"+day1+"天");
    }

    @Override
    public void onDownFail(String error) {
        Log.e("TAG", "数据获取失败：" + error);
    }

    @Override
    public void onBannerSuccess(BannerBean bannerBean) {
        bannerList = new ArrayList<>();
        List<BannerBean.DataDTO.AdvListDTO> advList = bannerBean.getData().getAdvList();
        bannerList.addAll(advList);
        //banner图片
        chooseBanner.setImages(bannerList)
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        BannerBean.DataDTO.AdvListDTO newPath = (BannerBean.DataDTO.AdvListDTO) path;
                        Glide.with(activity).load(newPath.getAdvImg()).into(imageView);
                    }
                }).start();

    }

    @Override
    public void onBannerFail(String error) {
        Log.e("TAG", "数据获取失败：" + error);
    }

    @Override
    public void onSuccess(CourseBean courseBean) {
        //课程
        List<CourseBean.DataDTO.CourseCategoryListDTO.SubListDTO> subList = courseBean.getData().getCourseCategoryList().get(0).getSubList();
        subListDTOS.addAll(subList);
        adapter.notifyDataSetChanged();
    }


    @Override
    public void onFail(String error) {
        Log.e("TAG", "数据获取失败：" + error);
    }
}