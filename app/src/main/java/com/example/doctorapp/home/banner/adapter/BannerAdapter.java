package com.example.doctorapp.home.banner.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.doctorapp.R;
import com.example.doctorapp.home.banner.bean.BannerBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class BannerAdapter  extends DelegateAdapter.Adapter {
    private ArrayList<BannerBean.DataDTO.AdvListDTO> list;
    private SingleLayoutHelper singleLayoutHelper;
    private Context context;

    public BannerAdapter(ArrayList<BannerBean.DataDTO.AdvListDTO> list, SingleLayoutHelper singleLayoutHelper, Context context) {
        this.list = list;
        this.singleLayoutHelper = singleLayoutHelper;
        this.context = context;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return singleLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.home_banner_item, parent, false);
        return new HomeBannerViewHolder(inflate);
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
      HomeBannerViewHolder viewHolder= (HomeBannerViewHolder) holder;
     //banner
      viewHolder.banner.setImages(list)
              .setImageLoader(new ImageLoader() {
                  @Override
                  public void displayImage(Context context, Object path, ImageView imageView) {
                      BannerBean.DataDTO.AdvListDTO newPath= (BannerBean.DataDTO.AdvListDTO) path;
                      Glide.with(context).load(newPath.getAdvImg()).into(imageView);

                      imageView.setOnClickListener(new View.OnClickListener() {
                          @Override
                          public void onClick(View v) {
                              itemListener.itemClick(position);
                          }
                      });
                  }
              }).start();
    }

    @Override
    public int getItemCount() {
        return 1;
    }


    class HomeBannerViewHolder extends RecyclerView.ViewHolder{

        private Banner banner;
        public HomeBannerViewHolder(@NonNull View itemView) {
            super(itemView);
            banner=itemView.findViewById(R.id.ban_image);
        }
    }
}
