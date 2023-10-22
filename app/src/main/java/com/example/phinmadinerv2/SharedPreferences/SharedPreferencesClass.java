package com.example.phinmadinerv2.SharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesClass {
    SharedPreferences sharedPreferences;
    public SharedPreferencesClass(Context context) {
        sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
    }
}
