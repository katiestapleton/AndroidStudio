package com.katie.appeventtracking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.katie.appeventtracking.databinding.ActivityManageEventBinding;

// THIS ACTIVITY IS AN ALTERATIVE TO EVENTADDFRAG. NOT CURRENTLY USED
public class ManageEvent extends AppCompatActivity {

    private ActivityManageEventBinding binding;

// SQLite understanding https://www.youtube.com/watch?v=h0hryA3K6GI&list=PLuji25yj7oIIN9LLWq0OBXeiPwfsCyyw2&index=2
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityManageEventBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_manage_event);

        // adds event to database
        binding.btnSubmitEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: ADD EVENT TO DB
                //insertEvent();
            }
        });

        // return to event screen
        binding.btnReturnEvent.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        });

    }

    /*
    // ADD event to SQL database
    public void insertEvent() {
        try {
            String date = binding.inputEventDate.getText().toString();
            String time  = binding.inputEventTime.getText().toString();
            String name  = binding.inputEventName.getText().toString();
            String describe  = binding.inputEventDescribe.getText().toString();

            // create or connect to DB
            SQLiteDatabase db = openOrCreateDatabase("events.db", Context.MODE_PRIVATE, null);
            // add an autoincrement key as primary key
            db.execSQL("CREATE TABLE IF NOT EXISTS events(id INTEGER PRIMARY KEY AUTOINCREMENT, date VARCHAR, time VARCHAR, name VARCHAR, describe VARCHAR)");



            //make statement reusable
            String sql = "insert into records(date,time,name,describe)values(?, ?, ?, ?)";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(1, date);
            statement.bindString(2, time);
            statement.bindString(3, name);
            statement.bindString(4, describe);
            statement.execute();
            //message sent to user
            Toast.makeText(this, "Event added", Toast.LENGTH_SHORT).show();
        }
        catch (Exception exception) {
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
        }
    }*/
}