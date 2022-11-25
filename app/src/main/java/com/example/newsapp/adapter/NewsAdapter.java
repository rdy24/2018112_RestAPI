package com.example.newsapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newsapp.R;
import com.example.newsapp.model.ArticlesItem;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    private final Context context;
    private List<ArticlesItem> newsLists;

    public NewsAdapter(Context context, List<ArticlesItem> newsLists) {
        this.context = context;
        this.newsLists = newsLists;
    }

    public List<ArticlesItem> getNewsLists() {
        return newsLists;
    }

    public void setNewsLists(List<ArticlesItem> newsLists) {
        this.newsLists = newsLists;
    }

    @NonNull
    @Override
    public NewsAdapter.NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_news, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.NewsViewHolder holder, int position) {
        ArticlesItem newsList = getNewsLists().get(position);
        Glide.with(context).load(newsList.getUrlToImage()).into(holder.imageView);
        holder.textView1.setText(newsList.getTitle());
        holder.textView2.setText(newsList.getSource().getName());
    }

    @Override
    public int getItemCount() {
        return newsLists.size();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView1, textView2;
        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.textView1);
            textView2 = itemView.findViewById(R.id.textView2);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

}
