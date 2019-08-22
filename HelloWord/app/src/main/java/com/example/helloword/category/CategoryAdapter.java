package com.example.helloword.category;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.helloword.R;
import com.example.helloword.View.SquareRelativeLayout;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CateViewHolder> {

    Context context;
    ArrayList<Category> cateData;

    public CategoryAdapter(Context context, ArrayList<Category> cateData) {
        this.context = context;
        this.cateData = cateData;
    }

    @NonNull
    @Override
    public CateViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from( context ).inflate( R.layout.category_item_layout, viewGroup, false );
        return new CateViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull CateViewHolder cateViewHolder, int i) {
        Category category = cateData.get( i );
        cateViewHolder.tvCategory.setText( category.name );
        Picasso.get().load( category.urlCategory ).into( cateViewHolder.imgCategory );
        if (category.getType() == 2) {
            cateViewHolder.clCateItem.setBackgroundDrawable( context.getResources().getDrawable( R.drawable.gradient_yellow_bg ) );
        } else if (i == 0) {
            cateViewHolder.clCateItem.setBackgroundDrawable( context.getResources().getDrawable( R.drawable.gradient_orange_dark_bg ) );

        } else if (i == cateData.size() - 1) {
            cateViewHolder.clCateItem.setBackgroundDrawable( context.getResources().getDrawable( R.drawable.gradient_ping_bg ) );
        }else {
            cateViewHolder.clCateItem.setBackgroundDrawable( context.getResources().getDrawable( R.drawable.gradient_orange_bg ) );
        }


    }

    @Override
    public int getItemCount() {
        return cateData.size();
    }

    public class CateViewHolder extends RecyclerView.ViewHolder {
        ImageView imgCategory;
        TextView tvCategory;
        SquareRelativeLayout clCateItem;

        public CateViewHolder(@NonNull View itemView) {
            super( itemView );
            imgCategory = itemView.findViewById( R.id.img_category );
            tvCategory = itemView.findViewById( R.id.tv_category );
            clCateItem = itemView.findViewById( R.id.sr_item_cate );

        }
    }

}
