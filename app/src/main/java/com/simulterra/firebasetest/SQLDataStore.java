package com.simulterra.firebasetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Gajanan on 07/12/2015.
 */
public class SQLDataStore extends SQLiteOpenHelper implements DataStore
{
    private final String TAG = this.getClass().getSimpleName();

    private static SQLDataStore sInstance;

    private static final String DATABASE_NAME = "howzap";
    private static final String DATABASE_TABLE = "contacts";
    private static final int DATABASE_VERSION = 1;

    private ContactSQLController mContactSQLController = null;

    /**
     * Constructor should be private to prevent direct instantiation.
     * make call to static method "getInstance()" instead.
     */
    private SQLDataStore(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static synchronized SQLDataStore getInstance(Context context)
    {
        if (sInstance == null)
        {
            sInstance = new SQLDataStore(context.getApplicationContext());
        }
        return sInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
    }

    public ContactController getContactController()
    {
        return mContactSQLController;
    }

}
