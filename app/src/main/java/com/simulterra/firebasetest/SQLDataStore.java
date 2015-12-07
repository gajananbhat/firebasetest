package com.simulterra.firebasetest;

import android.content.Context;

/**
 * Created by Gajanan on 07/12/2015.
 */
public class SQLDataStore implements DataStore
{
    private final String TAG = this.getClass().getSimpleName();

    private Context context;

    public SQLDataStore(Context ctx)
    {
        this.context = ctx;
    }
}
