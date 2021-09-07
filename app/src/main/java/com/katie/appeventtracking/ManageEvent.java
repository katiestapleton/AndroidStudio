package com.katie.appeventtracking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ManageEvent extends AppCompatActivity {

    EditText inputEventDate, inputEventTime, inputEventName, inputEventDescribe;
    Button btnSubmitEvent, btnReturnEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_event);

        // call items from XML
        inputEventDate = findViewById(R.id.inputEventDate);
        inputEventTime = findViewById(R.id.inputEventTime);
        inputEventName = findViewById(R.id.inputEventName);
        inputEventDescribe = findViewById(R.id.inputEventDescribe);

        btnSubmitEvent = findViewById(R.id.btnSubmitEvent);
        btnReturnEvent = findViewById(R.id.btnReturnEvent);

        // adds event to database
        btnSubmitEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insert();
            }
        });

        // return to event screen
        btnReturnEvent.setOnClickListener(view -> {
            //NavHostFragment.findNavController(EventAddFragment.this)
            //        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        });

    }

    // ADD event to SQL database
    public void insert() {
        try {
            String date = inputEventDate.getText().toString();
            String time  = inputEventTime.getText().toString();
            String name  = inputEventName.getText().toString();
            String describe  = inputEventDescribe.getText().toString();

            // create or open SQL database
            SQLiteDatabase db = openOrCreateDatabase("EventDb", Context.MODE_PRIVATE, null);
            // add an autoincrement key as primary key
            db.execSQL("CREATE TABLE IF NOT EXISTS events(id INTEGER PRIMARY KEY AUTOINCREMENT, date VARCHAR, time VARCHAR, name VARCHAR, describe VARCHAR)");

            //make statement reusable
            String sql = "insert into records(date,time,name,describe)values(?, ?, ?)";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(1, date);
            statement.bindString(1, time);
            statement.bindString(1, name);
            statement.bindString(1, describe);
            statement.execute();
            //message sent to user
            Toast.makeText(this, "Event added", Toast.LENGTH_SHORT).show();
        }
        catch (Exception exception) {
            //send error message to user
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
        }
    }
}