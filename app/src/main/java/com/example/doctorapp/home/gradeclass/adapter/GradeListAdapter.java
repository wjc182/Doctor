package com.example.doctorapp.home.gradeclass.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.doctorapp.R;
import com.example.doctorapp.home.gradeclass.bean.GradeClassBean;

import java.util.ArrayList;

public class GradeListAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<GradeClassBean.DataBean.CourseGradeListBean> list;

    public GradeListAdapter(Context context, ArrayList<GradeClassBean.DataBean.CourseGradeListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_grade_list_item, parent, false);

        return new GradeListViewHolder(view);
    }
    private ClassListener classListener;

    public void setClassListener(ClassListener classListener) {
        this.classListener = classListener;
    }

    public interface ClassListener{
        void itemListener(int pos);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        GradeClassBean.DataBean.CourseGradeListBean gradeListDTO = list.get(position);
        GradeListViewHolder viewHolder= (GradeListViewHolder) holder;

        viewHolder.name.setText(gradeListDTO.getGradeName());
        Glide.with(context).load(gradeListDTO.getClassLogo()).into(viewHolder.imageView);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                classListener.itemListener(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class GradeListViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView name;

        public GradeListViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.classLogo);
            name=itemView.findViewById(R.id.gradeName);
        }
    }
}
