package com.simulterra.firebasetest;

import android.content.Context;

/**
 * Created by Gajanan on 07/12/2015.
 */
public class FirebaseDataStore implements DataStore
{
    private final String TAG = this.getClass().getSimpleName();

    private Context context;

    private static FirebaseDataStore sInstance;

    private static final String FIREBASE_HOME = "https://hzfbtest.firebaseio.com/";

    /**
     * Constructor should be private to prevent direct instantiation.
     * make call to static method "getInstance()" instead.
     */
    private FirebaseDataStore(Context context)
    {
        this.context = context;
    }

    public static synchronized FirebaseDataStore getInstance(Context context)
    {
        if (sInstance == null)
        {
            sInstance = new FirebaseDataStore(context.getApplicationContext());
        }
        return sInstance;
    }
}
