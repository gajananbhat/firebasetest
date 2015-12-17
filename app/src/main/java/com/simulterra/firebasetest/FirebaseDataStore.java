package com.simulterra.firebasetest;

import android.content.Context;

import com.firebase.client.Firebase;

/**
 * Created by Gajanan on 07/12/2015.
 */
public class FirebaseDataStore implements IDataStore
{
    private final String TAG = this.getClass().getSimpleName();

    private Context context;

    private static FirebaseDataStore sInstance;

    private static final String FIREBASE_HOME = "https://hzfbtest.firebaseio.com/";

    private Firebase mFBRootRef = null;

    private ContactFBController mContactFBController = null;

    /**
     * Constructor should be private to prevent direct instantiation.
     * make call to static method "getInstance()" instead.
     */
    private FirebaseDataStore(Context context)
    {
        this.context = context;
        this.mContactFBController = new ContactFBController(this);
        initializeReferences();
    }

    public static synchronized FirebaseDataStore getInstance(Context context)
    {
        if (sInstance == null)
        {
            sInstance = new FirebaseDataStore(context.getApplicationContext());
        }
        return sInstance;
    }

    public ContactFBController getContactController()
    {
        return mContactFBController;
    }

    public void initializeReferences()
    {
        mFBRootRef = new Firebase(FIREBASE_HOME);
    }

    public Firebase getFBRootRef()
    {
        return mFBRootRef;
    }
}
