package com.example.helloword.recycleview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.helloword.R;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewhoder> {

    ArrayList<History> data =new ArrayList<>(  );
    Context context;



    @NonNull
    @Override
    public HistoryViewhoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        /*View historyView= LayoutInflater.from(viewGroup.getContext()).inflate( R.layout.history_item_layout,viewGroup,false );
        return new HistoryViewhoder( historyView );*/
        View view=LayoutInflater.from( context ).inflate( R.layout.history_item_layout,viewGroup,false );
        HistoryViewhoder historyViewhoder=new HistoryViewhoder( view );
        return historyViewhoder;
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewhoder historyViewhoder, int i) {
        History history= data.get( i );
        historyViewhoder.tvTitle.setText( history.title );
        historyViewhoder.tvPoint.setText( history.point+"");
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class HistoryViewhoder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvPoint;
        public HistoryViewhoder(@NonNull View itemView) {
            super( itemView );
            tvTitle=itemView.findViewById( R.id.tv_title );
            tvPoint=itemView.findViewById( R.id.tv_point );

        }
    }
}
