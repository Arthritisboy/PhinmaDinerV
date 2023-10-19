package com.example.phinmadinerv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.phinmadinerv2.SharedPreferences.SharedPreferencesClass;


public class MainActivity extends AppCompatActivity {
    SharedPreferencesClass sharedPreferenceClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferenceClass = new SharedPreferencesClass(this);

        if(sharedPreferenceClass.getLoginStatus()) {
            sharedPreferenceClass.saveLoginStatus(false);
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);

        } else if (sharedPreferenceClass.getLoginStatus()) {
            sharedPreferenceClass.saveLoginStatus(true);
            Intent intent = new Intent(getApplicationContext(), LandingPage.class);
            startActivity(intent);
        }
    }
}