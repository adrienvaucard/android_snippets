package com.example.contactlist.bo;

import android.os.Parcel;
import android.os.Parcelable;

public class Contact implements Parcelable {
    String firstname, lastname;

    public Contact(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    protected Contact (Parcel in) {
        firstname = in.readString();
        lastname = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(firstname);
        parcel.writeString(lastname);
    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
