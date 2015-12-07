package com.simulterra.firebasetest;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by Administrator on 07/12/2015.
 */
public class DataStoreFactory
{
    private final String TAG = this.getClass().getSimpleName();

    private Context context;

    public DataStoreFactory(Context ctx)
    {
        this.context = ctx;
    }

    public DataStore getDataStore()
    {
        SharedPreferences prefs = context.getSharedPreferences("HowzapPrefs", 0);
        String data_store = prefs.getString("data_store", null);
        Log.d(TAG, "DATA_STORE=" + prefs.getString("data_store", null));

        if (data_store.equalsIgnoreCase("Firebase"))
        {
            return new FirebaseDataStore(context);
        }
        else if (data_store.equalsIgnoreCase("SQL"))
        {
            return new SQLDataStore(context);
        }

        return null;
    }
}
