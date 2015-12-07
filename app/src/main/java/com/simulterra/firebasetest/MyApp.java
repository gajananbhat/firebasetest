package com.simulterra.firebasetest;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;

import com.firebase.client.Firebase;

/**
 * Created by Gajanan on 07/12/2015.
 */

public class MyApp extends Application
{

    private final String TAG = this.getClass().getSimpleName();

    @Override
    public void onCreate()
    {

        super.onCreate();

        String data_store = "Firebase"; // Default

        try
        {
            ApplicationInfo ai = getPackageManager().getApplicationInfo(this.getPackageName(), PackageManager.GET_META_DATA);
            Bundle mdBundle = ai.metaData;
            data_store = mdBundle.getString("com.simulterra.firebasetest.data_store");
            Log.d(TAG, data_store);
        } catch (PackageManager.NameNotFoundException e) {
           Log.e(TAG, "Failed to load meta-data, NameNotFound: " + e.getMessage());
        } catch (NullPointerException e) {
           Log.e(TAG, "Failed to load meta-data, NullPointer: " + e.getMessage());
        }

        //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences settings = this.getSharedPreferences("HowzapPrefs", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("data_store", data_store);

        // Commit the edits!
        editor.commit();

        DataStore ds = new DataStoreFactory(this).getDataStore();

        Firebase.setAndroidContext(this);
        Firebase.getDefaultConfig().setPersistenceEnabled(true);
    }

}
