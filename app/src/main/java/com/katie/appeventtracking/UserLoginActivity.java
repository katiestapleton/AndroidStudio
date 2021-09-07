package com.katie.appeventtracking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserLoginActivity extends AppCompatActivity {

    EditText username, password;
    Button btnLogin, btnNewUser;
    private static final int PERMISSION_REQUEST_SEND_SMS = 0;

    // source: check for email pattern https://www.codebrainer.com/blog/registration-form-in-android-check-email-is-valid-is-empty
    // source: adding in a limited # of tries  https://github.com/Dheeraj22/Professor_DK/blob/master/Simple%20Login%20Screen%20App%20Latest/E01/app/src/main/java/com/example/simpleloginapp/MainActivity.java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        // assigns values to layout items
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        btnLogin = findViewById(R.id.btnLogin);
        btnNewUser = findViewById(R.id.btnNewUser);

        // instantiates userDatabase
        Database database = new Database(getApplicationContext());

        // when login button is clicked, checks username and password

        //SAME AS: btnNewLogin.setOnClickListener(new View.OnClickListener() {
        btnLogin.setOnClickListener(view -> {
            //retrieve user input
            String user = username.getText().toString();
            String pass = password.getText().toString();

            //check if username and password match
            if(user.equals("user") && pass.equals("password")) {
                Toast.makeText(UserLoginActivity.this, "Welcome back!", Toast.LENGTH_SHORT).show();
                // navigates to main screen
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(UserLoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
            }
        });

        // when "create new account" button is clicked, adds new user
        btnNewUser.setOnClickListener(view -> {

            //retrieve user input
            String user = username.getText().toString();
            String pass = password.getText().toString();

            //check if account already exists
            // TODO: VERIFY CREDENTIALS
            // check if meets requirements

            // navigates to main screen
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        });

    }


}