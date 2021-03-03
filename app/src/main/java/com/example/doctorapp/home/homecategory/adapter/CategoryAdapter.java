package com.example.doctorapp.home.homecategory.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.doctorapp.R;
import com.example.doctorapp.home.banner.adapter.BannerAdapter;
import com.example.doctorapp.home.homecategory.bean.CategoryBean;

import java.util.ArrayList;

public class CategoryAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private ArrayList<CategoryBean.DataDTO.CourseCategoryListDTO> list;
    private GridLayoutHelper gridLayoutHelper;

    public CategoryAdapter(Context context, ArrayList<CategoryBean.DataDTO.CourseCategoryListDTO> list, GridLayoutHelper gridLayoutHelper) {
        this.context = context;
        this.list = list;
        this.gridLayoutHelper = gridLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {

        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_catergory_item, parent, false);

        return new CategoryViewHolder(view);
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
        CategoryBean.DataDTO.CourseCategoryListDTO cour = list.get(position);
        CategoryViewHolder holder1= (CategoryViewHolder) holder;
        String categoryName = cour.getCategoryName();
        holder1.name.setText(categoryName);

        switch (categoryName){
            case "执业药师":
                Glide.with(context).load(R.drawable.zhiyeyaoshi).into(holder1.imageView);
                break;
            case "执业医师":
                Glide.with(context).load(R.drawable.zhiyeyishi).into(holder1.imageView);
                break;
            case "职称药师":
                Glide.with(context).load(R.drawable.yaoxuezhicheng).into(holder1.imageView);
                break;
            case "健康管理师":
                Glide.with(context).load(R.drawable.jiankangguanlishi).into(holder1.imageView);
                break;
            case "中医（专长）":
                Glide.with(context).load(R.drawable.xuelitisheng).into(holder1.imageView);
                break;
        }
        holder1.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemListener.itemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size()-3;
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView name;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.categoryImage);
            name=itemView.findViewById(R.id.categoryName);
        }
    }
}
