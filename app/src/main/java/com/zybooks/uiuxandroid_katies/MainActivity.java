package com.zybooks.uiuxandroid_katies;

import android.content.Intent;
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

        Button button = findViewById(R.id.buttonSayHello);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView outputText = findViewById(R.id.textGreeting);
                EditText inputText = findViewById(R.id.nameText);

                if (inputText.getText() != null) {
                    String sayHelloMessage = (getString(R.string.welcomeGreeting) + inputText.getText());
                    outputText.setText(sayHelloMessage);
                } else {
                    outputText.setError("You must enter a name");
                }
            }
        });
    }


}
