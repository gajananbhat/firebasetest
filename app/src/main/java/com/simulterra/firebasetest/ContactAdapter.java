package com.simulterra.firebasetest;

import android.util.Log;

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
    private final String TAG = this.getClass().getSimpleName();

    private ContactListener mContactListener = null;

    public void setContactListener(ContactListener mContactListener) {
        this.mContactListener = mContactListener;
    }

    public void createContact()
    {

    }

    public void getContacts()
    {
        final List<Contact> contactList = new ArrayList<Contact>();

        Firebase myFirebaseRef = new Firebase("https://hzfbtest.firebaseio.com/contacts");
        myFirebaseRef.addListenerForSingleValueEvent(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot snapshot)
            {
                System.out.println(snapshot.getValue());
                Log.d(TAG, snapshot.getValue().toString());
                for (DataSnapshot child : snapshot.getChildren())
                {
                    //Contact c = new Contact(child.child("name").getValue().toString());
                    Contact c = child.getValue(Contact.class);
                    System.out.println(c.getFullName());
                    contactList.add(c);
                }
                mContactListener.getContactsComplete(contactList);
            }

            @Override public void onCancelled(FirebaseError error)
            {
            }
        });
    }

    public void updateContact()
    {

    }

    public void deleteContact()
    {

    }
}
