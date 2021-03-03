package com.example.doctorapp.choose.bookpic.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.doctorapp.R;
import com.example.doctorapp.choose.bookpic.bean.ChooseBookBean;

import java.util.ArrayList;

public class ChooseBookAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<ChooseBookBean.DataDTO> list;

    public ChooseBookAdapter(Context context, ArrayList<ChooseBookBean.DataDTO> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.choose_book_item, parent, false);

        return new ChooseBookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ChooseBookBean.DataDTO dto = list.get(position);
        ChooseBookViewHolder chooseBookViewHolder= (ChooseBookViewHolder) holder;
        Glide.with(context).load(dto.getPic()).into(chooseBookViewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ChooseBookViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        public ChooseBookViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.choose_book_image);
        }
    }
}
