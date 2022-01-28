package com.example.contactlist;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.contactlist.adapter.ContactAdapter;
import com.example.contactlist.bo.Contact;
import com.example.contactlist.viewmodel.ListFragmentViewModel;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ContactListFragment extends Fragment {
    private RecyclerView rv;
    private ContactAdapter adapter;
    private ListFragmentViewModel vm;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vm = new ViewModelProvider(this).get(ListFragmentViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initializeContacts();
        Observer<ArrayList<Contact>> observerList = contacts -> {
            adapter.setContactArrayList(contacts);
            rv.scrollToPosition(adapter.getItemCount() - 1);
        };
        vm.getContactArrayList().observe(getViewLifecycleOwner(), observerList);

        if (vm.getContactArrayList().getValue().isEmpty()) {
            fetchContacts();
        }


        super.onViewCreated(view, savedInstanceState);
    }

    private void initializeContacts() {
        rv = getView().findViewById(R.id.recyclerViewContact);
        adapter = new ContactAdapter();
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(adapter);
    }

    public void fetchContacts() {
        ArrayList<Contact> newContacts = new ArrayList<Contact>();
        newContacts.add(new Contact("Geoffrey", "Clermont"));
        newContacts.add(new Contact("Mattéo", "Lecuit"));
        newContacts.add(new Contact("Bigeard", "Null"));
        newContacts.add(new Contact("Adrien", "Lereverend"));
        vm.getContactArrayList().postValue(newContacts);
    }
}