package com.katie.appeventtracking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

// THIS ACTIVITY IS AN ALTERATIVE TO EVENTFRAG. NOT CURRENTLY IN USE
public class ReviewEvent extends AppCompatActivity {

    ListView myListView;
    ArrayList<String> titles = new ArrayList<String>();
    ArrayAdapter arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_event);

        // instantiates Database
        Database database = new Database(getApplicationContext());

        //connect to DB
        SQLiteDatabase db = openOrCreateDatabase("EventDb", Context.MODE_PRIVATE, null);

        myListView = findViewById(R.id.LVReviewEvent);
        final Cursor cursor = db.rawQuery("select * from records", null);
        int id = cursor.getColumnIndex("id");
        int date = cursor.getColumnIndex("date");
        int time = cursor.getColumnIndex("time");
        int name = cursor.getColumnIndex("name");
        int describe = cursor.getColumnIndex("describe");

        arrayAdapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,titles);
        myListView.setAdapter(arrayAdapter);

        final ArrayList<Event> events = new ArrayList<Event>();
        if(cursor.moveToFirst()) {
            do {
                Event event = new Event();
                event.id = cursor.getString(id);
                event.date = cursor.getString(date);
                event.time = cursor.getString(time);
                event.name = cursor.getString(name);
                event.describe = cursor.getString(describe);

                events.add(event);

                titles.add(cursor.getString(id) + " \t " + cursor.getString(date) + " \t "  + cursor.getString(time) + " \t "  + cursor.getString(name) + " \t "  + cursor.getString(describe) );
            } while (cursor.moveToNext());

            arrayAdapter.notifyDataSetChanged();
            myListView.invalidateViews();
        }

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String titling = titles.get(position).toString();

                Event event = events.get(position);
                Intent i = new Intent(getApplicationContext(),MainActivity.class);

                i.putExtra("id", event.id);
                i.putExtra("date", event.date);
                i.putExtra("time", event.time);
                i.putExtra("name", event.name);
                i.putExtra("describe", event.describe);
                startActivity(i);
            }
        });

    }
}