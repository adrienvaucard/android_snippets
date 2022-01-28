package com.example.contactlist.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactlist.databinding.RowLayoutContactBinding;

public class ContactViewHolder extends RecyclerView.ViewHolder {
    RowLayoutContactBinding binding;

    public ContactViewHolder(@NonNull RowLayoutContactBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
