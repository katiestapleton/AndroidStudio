package com.katie.appeventtracking;

import android.Manifest;
import android.content.pm.PackageManager;
import android.icu.text.SimpleDateFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;


import android.telephony.SmsManager;
import android.view.View;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.katie.appeventtracking.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static final int SEND_SMS_CODE = -1;
    private static final int PERMISSION_REQUEST_SEND_SMS = 0;
    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        // navigation bar
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);


        // ASK FOR SMS PERMISSION at runtime (classified as "dangerous" permission)
        // at runtime, check if send SMS permission is granted
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_DENIED) {
            //popup asking for SMS permission
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, PERMISSION_REQUEST_SEND_SMS);
            //send message if permission is granted (for the first time)
            if(ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "SMS authorized. You can now receive external alerts for upcoming events.", Toast.LENGTH_LONG).show();
            }
        }

        // sends SMS for same-day events IF permission has been granted
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
            SimpleDateFormat sdf = new SimpleDateFormat("MM-DD-YYYY");
            String currentDate = sdf.format(new Date());

            //send alerts for same day only
            //TODO: add mech to sort event date by desc date
            //TODO: check if today matches any date within table
            /*
                while (today = the event date in event table
                ex: i = 0; currentDate == call event from eventtable[i], i++.
                retrieve ID or specify location
                modify method below to add custom data
            */

            Intent sendIntent = new Intent(Intent.ACTION_VIEW);
            sendIntent.setData(Uri.parse("sms:" + "My Event Tracking Message"));
            startActivity(sendIntent);
            // FIXME: text body is not showing in SMS
            // TODO: specific event time, name, description to message
            sendIntent.putExtra("sms_body", "Upcoming event today!!! See Tracking Application");
            startActivity(sendIntent);
        }

    }

    // send SMS message
    protected void sendSMSMessage(){
        SmsManager smsManager = SmsManager.getDefault();
        //smsManager.sendDataMessage();
        //data message vs multi message
    }

    // CREATE DROP-DOWN USER MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button
        int id = item.getItemId();

        // user login
        if (id == R.id.userAccount) {
            Intent myAccount = new Intent(MainActivity.this, UserLoginActivity.class);
            startActivity(myAccount);
            return true;
        }

        // help option
        if (id == R.id.requestHelp) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

}