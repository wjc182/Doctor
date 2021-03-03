package com.example.doctorapp.home.course.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.service.autofill.ImageTransformation;
import android.util.Log;
import android.view.Choreographer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.doctorapp.R;
import com.example.doctorapp.fragment.ChooseFragment;
import com.example.doctorapp.home.course.bean.CourseBean;
import com.example.doctorapp.home.gradeclass.adapter.GradeListAdapter;
import com.example.doctorapp.home.gradeclass.bean.GradeClassBean;
import com.example.doctorapp.home.gradeclass.bean.GradeClassBodyBean;
import com.example.doctorapp.utils.ICallBack;
import com.example.doctorapp.utils.NetWorkRetrofit;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Retrofit;

import static com.umeng.analytics.pro.ba.a;
import static com.umeng.analytics.pro.ba.aa;
import static com.umeng.analytics.pro.ba.p;

public class CourseAdapter extends DelegateAdapter.Adapter {

    private Context context;
    private ArrayList<CourseBean.DataDTO.CourseCategoryListDTO> list;

    private SingleLayoutHelper singleLayoutHelper;



    public CourseAdapter(Context context, ArrayList<CourseBean.DataDTO.CourseCategoryListDTO> list, SingleLayoutHelper singleLayoutHelper) {
        this.context = context;
        this.list = list;
        this.singleLayoutHelper = singleLayoutHelper;

    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return singleLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_coure_item, parent, false);

        return new CourseViewHolder(view);
    }

    private ItemListener itemListener;

    public void setItemListener(ItemListener itemListener) {
        this.itemListener = itemListener;

    }

    public interface ItemListener{
        void setOnClickTitle(String onePostion, String twoPostion, ArrayList<GradeClassBean.DataBean.CourseGradeListBean>
                listBeans, GradeListAdapter gradeListAdapter);
    }


    private ItemListenerMore itemListenerMore;

    public void setItemListenerMore(ItemListenerMore itemListenerMore) {
        this.itemListenerMore = itemListenerMore;
    }

    public interface ItemListenerMore{
        void itemClickMore();
    }

    private ItemListenerThree itemListenerThree;

    public void setItemListenerThree(ItemListenerThree itemListenerThree) {
        this.itemListenerThree = itemListenerThree;
    }

    public interface ItemListenerThree{
        void itemClickThree(int position);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        //取消复用

        CourseBean.DataDTO.CourseCategoryListDTO subListDTO = list.get(position);
        CourseViewHolder viewHolder= (CourseViewHolder) holder;
        viewHolder.name.setText(subListDTO.getCategoryName());

        //水平布局
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        viewHolder.recyclerView.setLayoutManager(linearLayoutManager);

        //列表集合
        ArrayList<CourseBean.DataDTO.CourseCategoryListDTO.SubListDTO> subList = (ArrayList<CourseBean.DataDTO.CourseCategoryListDTO.SubListDTO>) subListDTO.getSubList();
        CourseListAdapter  adapter=new CourseListAdapter(context,subList);
        viewHolder.recyclerView.setAdapter(adapter);

        //班级
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(context);
        linearLayoutManager1.setOrientation(RecyclerView.HORIZONTAL);
        viewHolder.recyclerView1.setLayoutManager(linearLayoutManager1);
        //图片
        ArrayList<GradeClassBean.DataBean.CourseGradeListBean> courseGradeListDTOS = new ArrayList<>();

        //适配器
        GradeListAdapter gradeListAdapter = new GradeListAdapter(context, courseGradeListDTOS);
        viewHolder.recyclerView1.setAdapter(gradeListAdapter);

        //一级id
        String id1 = subListDTO.getId();
        //二级id5p
        String id2 = subList.get(0).getId();

        //默认显示第一条数据
        itemListener.setOnClickTitle(id1, id2, courseGradeListDTOS, gradeListAdapter);

        //接口回调
        adapter.setItemListener(new CourseListAdapter.ItemListener() {
            @Override
            public void itemClick(int pos) {
                //更新显示第一条数据
              //  netWorkRequest(id1, subList.get(pos).getId(), courseGradeListDTOS, gradeListAdapter);
                itemListener.setOnClickTitle(id1, subList.get(pos).getId(), courseGradeListDTOS, gradeListAdapter);

            }
        });

        //接口回调
        viewHolder.more.setOnClickListener(v -> itemListenerMore.itemClickMore());

        //三级图片点击跳转详情
        gradeListAdapter.setClassListener(new GradeListAdapter.ClassListener() {
            @Override
            public void itemListener(int pos) {
                itemListenerThree.itemClickThree(pos);
            }
        });
    }

    //P层的另一种写法
    public void netWorkRequest(String id1, String id2, ArrayList<GradeClassBean.DataBean.CourseGradeListBean> courseGradeListDTOS, GradeListAdapter gradeListAdapter){
        GradeClassBodyBean categoryBody = new GradeClassBodyBean();
        categoryBody.setType("0");
        categoryBody.setCategoryId1(id1);
        categoryBody.setCategoryId2(id2);

        Gson gson = new Gson();
        String str = gson.toJson(categoryBody);

        RequestBody body = RequestBody.create(MediaType.parse("application/json"),str);

        NetWorkRetrofit.getInstance().iRetrofitPost("course/app/api/grade/list", body, new ICallBack<GradeClassBean>() {
            @Override
            public void onSuccess(GradeClassBean gradeClassBean) {
                //重新添加
                courseGradeListDTOS.clear();
                courseGradeListDTOS.addAll(gradeClassBean.getData().getCourseGradeList());
                gradeListAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFail(String error) {

            }
        });
    }



    @Override
    public int getItemCount() {
        return list.size();
    }
    class CourseViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private RecyclerView recyclerView;
        private RecyclerView recyclerView1;
        private TextView more;
        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.course_categoryName);
            more= itemView.findViewById(R.id.more);
            recyclerView=itemView.findViewById(R.id.cour_rew);
            recyclerView1=itemView.findViewById(R.id.home_rew_course);
        }
    }
}
