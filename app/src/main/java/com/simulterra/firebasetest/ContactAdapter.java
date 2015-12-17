package com.simulterra.firebasetest;

import android.content.Context;
import android.util.Log;

/**
 * Created by Administrator on 07/12/2015.
 */
public class ContactAdapter
{
    private final String TAG = this.getClass().getSimpleName();

    private Context mContext = null;
    private IContactListener mContactListener = null;
    private IDataStore mDataStore = null;
    private IContactController mContactController = null;

    public ContactAdapter(Context context)
    {
        this.mContext = context;
        mDataStore = new DataStoreFactory(mContext).getDataStore();
        mContactController = mDataStore.getContactController();
    }

    public void setContactListener(IContactListener mContactListener)
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
