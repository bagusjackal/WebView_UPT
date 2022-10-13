package com.example.webview;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class ListNewsAdapter extends RecyclerView.Adapter<ListNewsAdapter.ListViewHolder> {
    private ArrayList<News> listNews;

    public ListNewsAdapter(ArrayList<News> list) {
        this.listNews = list;
    }
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main,parent, false);
                return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        News news = listNews.get(position);
        Glide.with(holder.itemView.getContext())
                .load(news.getPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(holder.imgPhoto);
        holder.tvName.setText(news.getName());
        holder.tvDetail.setText(news.getDetail());


    }

    @Override
    public int getItemCount() {

        return listNews.size();
    }



     class ListViewHolder extends RecyclerView.ViewHolder{
        ImageView imgPhoto;
        TextView tvName;
        TextView tvDetail;

        ListViewHolder(View itemview) {
            super(itemview);
            imgPhoto = itemview.findViewById(R.id.img_item_news);
            tvName = itemview.findViewById(R.id.tv_item_news);
            tvDetail = itemview.findViewById(R.id.tv_detail);
        }

    }
}
