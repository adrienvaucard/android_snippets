package com.example.contactlist.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactlist.R;
import com.example.contactlist.bo.Contact;
import com.example.contactlist.databinding.RowLayoutContactBinding;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> {
    ArrayList<Contact> contactArrayList;

    public ContactAdapter() {
        this.contactArrayList = contactArrayList;
    }

    public void addContact(Contact m) {
        contactArrayList.add(m);
        notifyItemInserted(contactArrayList.size() - 1);
    }

    public void setContactArrayList(ArrayList<Contact> contactArrayList) {
        this.contactArrayList = contactArrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RowLayoutContactBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.row_layout_contact,
                parent,
                false
        );
        return new ContactViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact cnt = contactArrayList.get(position);
        holder.binding.setContact(cnt);
    }

    @Override
    public int getItemCount() {
        return contactArrayList.size();
    }
}
