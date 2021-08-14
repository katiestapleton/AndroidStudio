package com.zybooks.uiuxandroid_katies;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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

        Button sayHelloButton = findViewById(R.id.buttonSayHello);
        EditText inputText = findViewById(R.id.nameText);
        TextView outputText = findViewById(R.id.textGreeting);

        sayHelloButton.setOnClickListener(sayHello);

        //disable sayHelloButton until user edits nameText
        sayHelloButton.setEnabled(false);
        inputText.addTextChangedListener(inputTextListener);
    }


    private View.OnClickListener sayHello = new View.OnClickListener() {
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
    };


    private TextWatcher inputTextListener = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            // does not disable button prior to chances
            //Button sayHelloButton = findViewById(R.id.buttonSayHello);
            //sayHelloButton.setEnabled(false);
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            EditText inputText = findViewById(R.id.nameText);
            Button sayHelloButton = findViewById(R.id.buttonSayHello);

            // source: https://stackoverflow.com/questions/22680106/how-to-disable-button-if-edittext-is-empty
            // user cannot submit with blank nameText
            String checkInputText = inputText.getText().toString().trim();
            sayHelloButton.setEnabled(!checkInputText.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {
            EditText inputText = findViewById(R.id.nameText);
            Button sayHelloButton = findViewById(R.id.buttonSayHello);

            // source: https://stackoverflow.com/questions/22680106/how-to-disable-button-if-edittext-is-empty
            // user cannot submit with blank nameText
            String checkInputText = inputText.getText().toString().trim();
            sayHelloButton.setEnabled(!checkInputText.isEmpty());
        }
    };

}
