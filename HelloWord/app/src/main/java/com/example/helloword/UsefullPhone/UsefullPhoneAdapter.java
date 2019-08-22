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

public class UsefullPhoneAdapter extends RecyclerView.Adapter<UsefullPhoneAdapter.ContactViewHolder>{
    ArrayList<UsefullPhone> data;
    Context context;

    public UsefullPhoneAdapter(ArrayList<UsefullPhone> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from( context ).inflate( R.layout.contact_item_layout,viewGroup, false);
        ContactViewHolder contactViewHolder =new ContactViewHolder( view );
        return contactViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder contactViewHolder, int i) {
        contactViewHolder.tvNameContact.setText( data.get( i ).name );
        contactViewHolder.tvPhoneContact.setText( data.get( i ).phone );

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {
        TextView tvNameContact,tvPhoneContact;
        public ContactViewHolder(@NonNull View itemView) {
            super( itemView );
            tvNameContact= itemView.findViewById( R.id.tv_name_contact );
            tvPhoneContact= itemView.findViewById( R.id.tv_phone_contact );
        }
    }


}
