package com.simulterra.firebasetest;

import android.content.Context;
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

    private Context mContext = null;
    private ContactListener mContactListener = null;
    private DataStore mDataStore = null;
    private ContactController mContactController = null;

    public ContactAdapter(Context context)
    {
        this.mContext = context;
        mDataStore = new DataStoreFactory(mContext).getDataStore();
        mContactController = mDataStore.getContactController();
    }

    public void setContactListener(ContactListener mContactListener)
    {
        this.mContactListener = mContactListener;
    }

    public void createContact()
    {

    }

    public void getContacts()
    {
        Log.d(TAG, "Inside getContacts.");
        mContactController.setContactListener(mContactListener);
        mContactController.getContacts();
    }

    public void updateContact(Contact contact)
    {
        Log.d(TAG, "Inside updateContact.");
        mContactController.updateContact(contact);
    }

    public void deleteContact()
    {

    }
}
