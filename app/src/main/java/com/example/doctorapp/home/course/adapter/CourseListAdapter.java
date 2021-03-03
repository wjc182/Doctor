package com.example.doctorapp.home.course.adapter;

import android.content.Context;
import android.content.PeriodicSync;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doctorapp.R;
import com.example.doctorapp.home.course.bean.CourseBean;
import com.example.doctorapp.home.gradeclass.adapter.GradeListAdapter;
import com.example.doctorapp.home.gradeclass.bean.GradeClassBean;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CourseListAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<CourseBean.DataDTO.CourseCategoryListDTO.SubListDTO> list;


    public CourseListAdapter(Context context, ArrayList<CourseBean.DataDTO.CourseCategoryListDTO.SubListDTO> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.home_course_list_item, parent, false);

        return new CourseListViewHolder(inflate);
    }

    private ItemListener itemListener;

    public void setItemListener(ItemListener itemListener) {
        this.itemListener = itemListener;
    }

    public interface ItemListener{
        void itemClick(int pos);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CourseBean.DataDTO.CourseCategoryListDTO.SubListDTO subListDTO = list.get(position);
        CourseListViewHolder viewHolder = (CourseListViewHolder) holder;
        viewHolder.listName.setText(subListDTO.getCategoryName());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //监听
                itemListener.itemClick(position);
            }
        });
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    class CourseListViewHolder extends RecyclerView.ViewHolder{
        private TextView listName;
        public CourseListViewHolder(@NonNull View itemView) {
            super(itemView);
            listName=itemView.findViewById(R.id.list_categoryName);
        }
    }
}
