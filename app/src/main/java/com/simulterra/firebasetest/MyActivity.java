package com.simulterra.firebasetest;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MyActivity extends AppCompatActivity implements ContactListener
{

    private final String TAG = this.getClass().getSimpleName();
    private ContactAdapter mContactAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        Log.d(TAG, "Reached here");
        //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        SharedPreferences prefs = getApplication().getSharedPreferences("HowzapPrefs", 0);
        Log.d(TAG, "DATA_STORE=" + prefs.getString("data_store", null));

        mContactAdapter = new ContactAdapter(getApplicationContext());
        mContactAdapter.setContactListener(this);
        mContactAdapter.getContacts();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void getContactsComplete(final List<Contact> contactList)
    {
        Log.d(TAG, "Inside getContactCompelte. ContactList size=" + contactList.size());
        System.out.println(contactList);
        Toast.makeText(MyActivity.this, "contacts retrieved :" + contactList.size(), Toast.LENGTH_SHORT).show();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll_test);

        if(((LinearLayout) linearLayout).getChildCount() > 0)
        {
            ((LinearLayout) linearLayout).removeAllViews();
        }

        int i = 1;
        List<EditText> allContactEditTexts = new ArrayList<EditText>();
        for (Contact contact : contactList)
        {
            EditText editText = new EditText(this);
            editText.setId(contact.getViewId());
            editText.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            editText.setText(contact.getFullName());
            //textView1.setBackgroundColor(0xff66ff66); // hex color 0xAARRGGBB
            editText.setPadding(20, 20, 20, 20);// in pixels (left, top, right, bottom)
            allContactEditTexts.add(editText);
            linearLayout.addView(editText);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MyActivity.this, "contacts count :" + contactList.size(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void saveContact(View view)
    {
        Log.d(TAG, "Inside saveContact.");
        EditText tv = (EditText) findViewById(1);
        Contact contact = new Contact(tv.getText().toString());
        //contact.setViewId(tv.getId());
        mContactAdapter.updateContact(contact);
    }
}
