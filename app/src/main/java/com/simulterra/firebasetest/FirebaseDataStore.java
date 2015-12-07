package com.simulterra.firebasetest;

import android.content.Context;

/**
 * Created by Gajanan on 07/12/2015.
 */
public class FirebaseDataStore implements DataStore
{
    private final String TAG = this.getClass().getSimpleName();

    private Context context;

    public FirebaseDataStore(Context ctx)
    {
        this.context = ctx;
    }
}
