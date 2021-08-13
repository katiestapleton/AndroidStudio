package com.zybooks.uiuxandroid_katies;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sayHello(View view) {
        TextView outputText = findViewById(R.id.textGreeting);
        EditText inputText = findViewById(R.id.nameText);
        Button button = findViewById(R.id.buttonSayHello);

        String sayHelloMessage = (getString(R.string.welcomeGreeting) + inputText.getText());
        button.setOnClickListener(view1 -> outputText.setText(sayHelloMessage));
    }
}