package com.example.doctorapp.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.doctorapp.R;
import com.example.doctorapp.activity.HomeBuyActivity;
import com.example.doctorapp.activity.LoginActivity;
import com.example.doctorapp.home.banner.adapter.BannerAdapter;
import com.example.doctorapp.home.banner.bean.BannerBean;
import com.example.doctorapp.home.banner.contract.BannerContract;
import com.example.doctorapp.home.banner.presenter.BannerPresenter;
import com.example.doctorapp.home.course.adapter.CourseAdapter;
import com.example.doctorapp.home.course.bean.CourseBean;
import com.example.doctorapp.home.course.contract.CourseContract;
import com.example.doctorapp.home.course.presenter.CoursePresenter;
import com.example.doctorapp.home.gradeclass.adapter.GradeListAdapter;
import com.example.doctorapp.home.gradeclass.bean.GradeClassBean;
import com.example.doctorapp.home.gradeclass.contract.GradeContract;
import com.example.doctorapp.home.gradeclass.presenter.GradePresenter;
import com.example.doctorapp.home.homecategory.adapter.CategoryAdapter;
import com.example.doctorapp.home.homecategory.bean.CategoryBean;
import com.example.doctorapp.home.homecategory.contract.CategoryContract;
import com.example.doctorapp.home.homecategory.presenter.CategoryPresenter;
import com.example.doctorapp.login.bean.LoginBean;
import com.tencent.mmkv.MMKV;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements BannerContract.iBannerView, CategoryContract.iCategoryView, CourseContract.iCourseView, GradeContract.iGradeView {

    private FragmentActivity activity;
    private RecyclerView recyclerView;
    private RecyclerView.RecycledViewPool viewPool;
    private ArrayList<BannerBean.DataDTO.AdvListDTO> bannerList;
    private BannerAdapter bannerAdapter;
    private ImageView ziXun;
    private EditText edSouSu;
    private ImageView keFu;
    private ArrayList<CategoryBean.DataDTO.CourseCategoryListDTO> courseCategoryListDTOS;
    private CategoryAdapter categoryAdapter;
    private ArrayList<CourseBean.DataDTO.CourseCategoryListDTO> subListDTOS;
    private CourseAdapter courseAdapter;
    private GradePresenter gradePresenter;
    private String oneId;
    private String twoId;
    private ArrayList<GradeClassBean.DataBean.CourseGradeListBean> arrayList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        activity = getActivity();
        initView(view);
        //准备数据
        initData();

        return view;
    }


    //接口回调
    private ItemFragmentEvent itemFragmentEvent;

    public void setItemFragmentEvent(ItemFragmentEvent itemFragmentEvent) {
        this.itemFragmentEvent = itemFragmentEvent;
    }

    public interface ItemFragmentEvent{
        void itemFragment();
    }

    //准备数据
    private void initData() {
        //banner
        BannerPresenter bannerPresenter = new BannerPresenter(this);
        bannerPresenter.getBanner();
        //banner下的
        CategoryPresenter categoryPresenter = new CategoryPresenter(this);
        categoryPresenter.getCategoryModel();
        //课程
        CoursePresenter coursePresenter = new CoursePresenter(this);
        coursePresenter.getCoursePresenter();
        //班级
        gradePresenter = new GradePresenter(this);

    }

    private void initView(View view) {
        //列表
        recyclerView = view.findViewById(R.id.rew_home_fragment);
        ziXun = view.findViewById(R.id.ziXun);
        edSouSu = view.findViewById(R.id.ed_SouSu);
        keFu = view.findViewById(R.id.keFu);

        //v_layout
        //布局管理
        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(activity);
        //绑定
        recyclerView.setLayoutManager(virtualLayoutManager);
        //组件复用
        viewPool = new RecyclerView.RecycledViewPool();
        recyclerView.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 10);
        //banner布局
        bannerMethod();

        //work布局
        workMethod();
        //course布局
        courseMethod();

        //总的适配器
        DelegateAdapter delegateAdapter = new DelegateAdapter(virtualLayoutManager);
        delegateAdapter.addAdapter(bannerAdapter);
        delegateAdapter.addAdapter(categoryAdapter);
        delegateAdapter.addAdapter(courseAdapter);

        recyclerView.setAdapter(delegateAdapter);

        //监听事件
        initListener();
        //详情页面
        arrayList = new ArrayList<>();
    }


    private void initListener() {
        //banner监听事件
        bannerAdapter.setItemListener(new BannerAdapter.ItemListener() {
            @Override
            public void itemClick(int pos) {
                Toast.makeText(activity, "banner点击事件未做", Toast.LENGTH_SHORT).show();
            }
        });

        //banner下的列表
        categoryAdapter.setItemListener(new CategoryAdapter.ItemListener() {
            @Override
            public void itemClick(int pos) {
                Toast.makeText(activity, "点击事件未做", Toast.LENGTH_SHORT).show();
            }
        });

        //三级列表监听事件
        courseAdapter.setItemListener(new CourseAdapter.ItemListener() {
            @Override
            public void setOnClickTitle(String onePostion, String twoPostion, ArrayList<GradeClassBean.DataBean.CourseGradeListBean> listBeans, GradeListAdapter gradeListAdapter) {
                //给选课传递ID
                oneId = onePostion;
                twoId = twoPostion;
                gradePresenter.getGradePresenter(onePostion,twoPostion,listBeans,gradeListAdapter);
            }
        });

        //更多跳转
        courseAdapter.setItemListenerMore(() -> {
            SharedPreferences sharedPreferences = activity.getSharedPreferences("name", Context.MODE_PRIVATE);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("id1",oneId);
            edit.putString("id2",twoId);
            //保存提交
            edit.commit();
            itemFragmentEvent.itemFragment();
        });

        //图片详情页
        courseAdapter.setItemListenerThree(new CourseAdapter.ItemListenerThree() {
            @Override
            public void itemClickThree(int position) {
                 //初始化MMKV
                 MMKV mmkv = MMKV.defaultMMKV();
                 //获取Token
                 LoginBean.DataDTO login = mmkv.decodeParcelable("login", LoginBean.DataDTO.class);
                 //判断Token是否为空
                 if(login==null){
                     startActivity(new Intent(activity, LoginActivity.class));
                 }else {
                     Intent intent = new Intent(activity, HomeBuyActivity.class);
                     GradeClassBean.DataBean.CourseGradeListBean bean = arrayList.get(position);
                     intent.putExtra("list",bean);
                     startActivity(intent);
                 }
             }
        });
    }

    private void courseMethod() {
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        // 公共属性
        singleLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        subListDTOS = new ArrayList<>();
        courseAdapter = new CourseAdapter(activity,subListDTOS,singleLayoutHelper);

    }

    private void workMethod() {

        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(3);
        // 在构造函数设置每行的网格个数
        // 公共属性
        gridLayoutHelper.setItemCount(1);// 设置布局里Item个数
        gridLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        gridLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        //gridLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        gridLayoutHelper.setAspectRatio(5);// 设置设置布局内每行布局的宽与高的比
        // gridLayoutHelper特有属性（下面会详细说明）
        gridLayoutHelper.setWeights(new float[]{20,20,20,20,20});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper.setVGap(20);// 控制子元素之间的垂直间距
        gridLayoutHelper.setHGap(20);// 控制子元素之间的水平间距
        gridLayoutHelper.setAutoExpand(true);//是否自动填充空白区域
        gridLayoutHelper.setSpanCount(5);// 设置每行多少个网格
        courseCategoryListDTOS = new ArrayList<>();
        categoryAdapter = new CategoryAdapter(activity, courseCategoryListDTOS, gridLayoutHelper);

    }

    private void bannerMethod() {
        //banner通栏布局
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        // 公共属性
        singleLayoutHelper.setItemCount(1);// 设置布局里Item个数

        singleLayoutHelper.setAspectRatio(2.5f);// 设置设置布局内每行布局的宽与高的比
        bannerList = new ArrayList<>();
        bannerAdapter = new BannerAdapter(bannerList, singleLayoutHelper, activity);
    }

    @Override
    public void onBannerSuccess(BannerBean bannerBean) {

        List<BannerBean.DataDTO.AdvListDTO> advList = bannerBean.getData().getAdvList();
        bannerList.addAll(advList);
        //刷新适配器
        bannerAdapter.notifyDataSetChanged();
    }

    @Override
    public void onBannerFail(String error) {
        Log.e("TAG", "请求失败：" + error);
    }


    @Override
    public void onSuccess(CategoryBean categoryBean) {
        //banner下的数据
        courseCategoryListDTOS.addAll(categoryBean.getData().getCourseCategoryList());
        categoryAdapter.notifyDataSetChanged();
    }

    @Override
    public void onSuccess(CourseBean courseBean) {
        //课程
        List<CourseBean.DataDTO.CourseCategoryListDTO> subList = courseBean.getData().getCourseCategoryList();
        subListDTOS.addAll(subList);
        courseAdapter.notifyDataSetChanged();
    }

    @Override
    public void onSuccess(GradeClassBean gradeClassBean) {
        //班级
        List<GradeClassBean.DataBean.CourseGradeListBean> courseGradeList = gradeClassBean.getData().getCourseGradeList();
        arrayList.clear();
        arrayList.addAll(courseGradeList);
    }

    @Override
    public void onFail(String error) {
        Log.e("TAG","获取数据错误："+error);
    }
}
