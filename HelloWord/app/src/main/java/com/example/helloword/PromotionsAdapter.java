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

public class PromotionsAdapter extends RecyclerView.Adapter<PromotionsAdapter.PromotionsViewHolder> {

    Context context;
    ArrayList<News> promotionsArrayList;

    public PromotionsAdapter(Context context, ArrayList<News> promotionsArrayList) {
        this.context = context;
        this.promotionsArrayList = promotionsArrayList;
    }

    @NonNull
    @Override
    public PromotionsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View newsView= LayoutInflater.from(viewGroup.getContext()).inflate( R.layout.item,viewGroup,false );

        return new PromotionsViewHolder( newsView );
    }

    @Override
    public void onBindViewHolder(@NonNull PromotionsViewHolder newsViewHolder, int i) {
        News news= promotionsArrayList.get( i );
        newsViewHolder.tvTitle.setText( news.content );
        Picasso.get().load(news.urlImage).into(newsViewHolder.imgNews);
    }

    @Override
    public int getItemCount() {
        return promotionsArrayList.size();
    }

    public class PromotionsViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        ImageView imgNews;
        public PromotionsViewHolder(@NonNull View itemView) {
            super( itemView );
            tvTitle=(TextView) itemView.findViewById( R.id.tv_title_history );
            imgNews=(ImageView) itemView.findViewById( R.id.img_news );



        }
    }
}
