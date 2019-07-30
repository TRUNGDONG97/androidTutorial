package com.example.helloword.recycleview;

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

import de.hdodenhof.circleimageview.CircleImageView;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewhoder> {

    ArrayList<History> data;
    Context context;

    public HistoryAdapter(ArrayList<History> data, Context context) {
        this.data = data;
        this.context = context;
}

    @NonNull
    @Override
    public HistoryViewhoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from( context ).inflate( R.layout.history_item_layout, viewGroup, false );
        HistoryViewhoder historyViewhoder = new HistoryViewhoder( view );
        return historyViewhoder;
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewhoder historyViewhoder, int i) {
        History history = data.get( i );
        Picasso.get().load( history.icon ).into( historyViewhoder.imgHistory );
        historyViewhoder.tvTitle.setText( history.title );
        historyViewhoder.tvBalance.setText( "Số dư : " + history.balance );
        historyViewhoder.tvCode.setText( "Mã giao dịch : " + history.code );
        historyViewhoder.tvDate.setText( history.createDate );
        historyViewhoder.tvPoint.setText( "+" + history.point + "đ" );

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class HistoryViewhoder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvCode, tvPoint, tvDate, tvBalance;
        CircleImageView imgHistory;


        public HistoryViewhoder(@NonNull View itemView) {
            super( itemView );
            imgHistory = itemView.findViewById( R.id.img_icon );
            tvTitle = itemView.findViewById( R.id.tv_title_history );
            tvBalance = itemView.findViewById( R.id.tv_balance );
            tvCode = itemView.findViewById( R.id.tv_code );
            tvDate = itemView.findViewById( R.id.tv_date );
            tvPoint = itemView.findViewById( R.id.tv_point );

        }
    }
}
