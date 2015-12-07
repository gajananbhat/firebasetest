package com.simulterra.firebasetest;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 07/12/2015.
 */
public class ContactAdapter
{

    private ContactListener mContactListener = null;

    public void setContactListener(ContactListener mContactListener) {
        this.mContactListener = mContactListener;
    }

    public void createContact()
    {

    }

    public List<Contact> getContacts()
    {
        List<Contact> contactList = new ArrayList<Contact>();

        Firebase myFirebaseRef = new Firebase("https://howzap.firebaseio.com/");
        myFirebaseRef.child("message").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot snapshot) {
                System.out.println(snapshot.getValue());  //prints "Do you have data? You'll love Firebase."
            }

            @Override public void onCancelled(FirebaseError error) { }

        });

        return contactList;
    }

    public void updateContact()
    {

    }

    public void deleteContact()
    {

    }
}
