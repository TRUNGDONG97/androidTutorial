package com.example.helloword.places;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.helloword.R;

import java.util.ArrayList;

public class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.placeViewHodel> {
    private Context context;
    private ArrayList<Place> arrayList;

    public PlacesAdapter(Context context, ArrayList<Place> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public placeViewHodel onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from( context ).inflate( R.layout.places_item_layout, viewGroup, false );
        placeViewHodel placeViewHodel = new placeViewHodel( view );
        return placeViewHodel;
    }

    @Override
    public void onBindViewHolder(@NonNull placeViewHodel placeViewHodel, int i) {
        Place place = arrayList.get( i );
        placeViewHodel.placeName.setText( place.placeName );
        if (place.isMoreDetail == 0 ) {
            placeViewHodel.moreDetail.setVisibility( View.GONE );
           // placeViewHodel.isPromotion.setVisibility( View.INVISIBLE );
            placeViewHodel.llPlaces.setBackgroundColor( Color.YELLOW);

        } else {
            placeViewHodel.moreDetail.setVisibility( View.VISIBLE );
            //placeViewHodel.isPromotion.setVisibility( View.INVISIBLE );
            placeViewHodel.llPlaces.setBackgroundColor( Color.parseColor( "#FF9800" ) );
        }
        if (place.isPromotion==0){
            placeViewHodel.isPromotion.setVisibility( View.GONE );
        }else {
            placeViewHodel.isPromotion.setVisibility( View.VISIBLE );
        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class placeViewHodel extends RecyclerView.ViewHolder {
        TextView placeName, isPromotion, moreDetail;
        LinearLayout llPlaces;

        public placeViewHodel(@NonNull View itemView) {
            super( itemView );
            placeName = itemView.findViewById( R.id.tv_places_name );
            isPromotion = itemView.findViewById( R.id.tv_is_promotion );
            moreDetail = itemView.findViewById( R.id.tv_detail );
            llPlaces = itemView.findViewById( R.id.ll_places );
        }
    }
}
