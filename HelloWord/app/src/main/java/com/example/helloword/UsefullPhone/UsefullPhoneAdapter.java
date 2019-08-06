package com.example.helloword.UsefullPhone;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.helloword.R;

import java.util.ArrayList;

public class UsefullPhoneAdapter extends RecyclerView.Adapter<UsefullPhoneAdapter.ContactViewHoder>{
    ArrayList<UsefullPhone> data;
    Context context;

    public UsefullPhoneAdapter(ArrayList<UsefullPhone> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ContactViewHoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from( context ).inflate( R.layout.contact_item_layout,viewGroup, false);
        ContactViewHoder contactViewHoder=new ContactViewHoder( view );
        return contactViewHoder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHoder contactViewHoder, int i) {
        contactViewHoder.tvNameContact.setText( data.get( i ).name );
        contactViewHoder.tvPhoneContact.setText( data.get( i ).phone );

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ContactViewHoder extends RecyclerView.ViewHolder {
        TextView tvNameContact,tvPhoneContact;
        public ContactViewHoder(@NonNull View itemView) {
            super( itemView );
            tvNameContact= itemView.findViewById( R.id.tv_name_contact );
            tvPhoneContact= itemView.findViewById( R.id.tv_phone_contact );
        }
    }


}
