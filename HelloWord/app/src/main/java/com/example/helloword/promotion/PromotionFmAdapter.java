package com.example.helloword.promotion;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.helloword.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PromotionFmAdapter extends RecyclerView.Adapter<PromotionFmAdapter.PromotionViewHolder> {
    Context context;
    ArrayList<Promotion> promotionArrayList;
    ArrayList<PlaceDetail> placeDetailList;

    public PromotionFmAdapter(Context context, ArrayList<Promotion> promotionArrayList, ArrayList<PlaceDetail> placeDetailList) {
        this.context = context;
        this.promotionArrayList = promotionArrayList;
        this.placeDetailList = placeDetailList;
    }

    @NonNull
    @Override
    public PromotionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from( context ).inflate( R.layout.promotion_item_layout,viewGroup,false );
        PromotionViewHolder promotionViewHolder=new PromotionViewHolder( view );
        return promotionViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PromotionViewHolder promotionViewHolder, int i) {
        Promotion promotion=promotionArrayList.get( i );
        PlaceDetail placeDetail=placeDetailList.get( i );
        Picasso.get().load( promotion.urlImage ).into( promotionViewHolder.imgPromotionFm );
        promotionViewHolder.tvPromotionName.setText( placeDetail.placeName );
        promotionViewHolder.tvPromotionPlaceName.setText( promotion.promotionName );
    }

    @Override
    public int getItemCount() {
        return promotionArrayList.size();
    }

    public class PromotionViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPromotionFm;
        TextView tvPromotionPlaceName,tvPromotionName;
        public PromotionViewHolder(@NonNull View itemView) {
            super( itemView );
            imgPromotionFm =itemView.findViewById( R.id.img_promotion_fm );
            tvPromotionPlaceName=itemView.findViewById( R.id.tv_promotion_place_name );
            tvPromotionName=itemView.findViewById( R.id.tv_promotion_name );

        }
    }
}
