package com.example.helloword;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    Context context;
    ArrayList<News> newsArrayList;

    public NewsAdapter(Context context, ArrayList<News> newsArrayList) {
        this.context = context;
        this.newsArrayList = newsArrayList;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View newsView= LayoutInflater.from(viewGroup.getContext()).inflate( R.layout.item,viewGroup,false );

        return new NewsViewHolder( newsView );
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder newsViewHolder, int i) {
        News news= newsArrayList.get( i );
        newsViewHolder.tvTitle.setText( news.content );
        Picasso.get().load(news.urlImage).into(newsViewHolder.imgNews);
    }

    @Override
    public int getItemCount() {
        return newsArrayList.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        ImageView imgNews;
        public NewsViewHolder(@NonNull View itemView) {
            super( itemView );
            tvTitle=(TextView) itemView.findViewById( R.id.tv_title );
            imgNews=(ImageView) itemView.findViewById( R.id.img_news );



        }
    }
}
