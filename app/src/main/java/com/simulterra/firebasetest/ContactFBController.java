package com.simulterra.firebasetest;

import android.util.Log;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 08/12/2015.
 */
public class ContactFBController implements ContactController
{
    private final String TAG = this.getClass().getSimpleName();

    private FirebaseDataStore mFBDataStore = null;

    private ContactListener mContactListener = null;

    public ContactFBController(FirebaseDataStore fds)
    {
        mFBDataStore = fds;
    }

    @Override
    public void setContactListener(ContactListener mContactListener)
    {
        this.mContactListener = mContactListener;
    }

    @Override
    public void getContacts()
    {
        Firebase myFirebaseRef = mFBDataStore.getFBRootRef().child("contacts");
        myFirebaseRef.addValueEventListener(new ValueEventListener()
        //myFirebaseRef.addListenerForSingleValueEvent(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot snapshot)
            {
                System.out.println(snapshot.getValue());
                Log.d(TAG, snapshot.getValue().toString());
                List<Contact> contactList = new ArrayList<Contact>();
                int i = 1;
                for (DataSnapshot child : snapshot.getChildren())
                {
                    //Contact c = new Contact(child.child("name").getValue().toString());
                    Contact c = child.getValue(Contact.class);
                    c.setId(child.getKey());
                    c.setViewId(i++);
                    Log.d(TAG, c.getId() + ":" + c.getFullName());
                    contactList.add(c);
                }
                mContactListener.getContactsComplete(contactList);
            }

            @Override public void onCancelled(FirebaseError error)
            {
            }
        });
    }

    @Override
    public void updateContact(Contact contact)
    {
        Log.d(TAG, "In updateContact");
        Firebase myFirebaseRef = mFBDataStore.getFBRootRef().child("contacts");
        myFirebaseRef.child("c1").setValue(contact);
    }
}
