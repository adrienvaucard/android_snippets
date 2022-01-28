package com.example.contactlist.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.contactlist.bo.Contact;

import java.util.ArrayList;

public class ListFragmentViewModel extends ViewModel {
    MutableLiveData<ArrayList<Contact>> arrayListContact;

    public MutableLiveData<ArrayList<Contact>> getContactArrayList() {
        if (arrayListContact == null) {
            this.arrayListContact = new MutableLiveData<>(new ArrayList<Contact>());
        }

        return this.arrayListContact;
    }
}
