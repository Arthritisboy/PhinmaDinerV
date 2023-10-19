package com.example.phinmadinerv2.SharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesClass {
    SharedPreferences sharedPreferences;
    public SharedPreferencesClass(Context context) {
        sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
    }

    public void saveLoginStatus(boolean isLoggedIn) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isLoggedIn", isLoggedIn);
        editor.apply();
    }

    public boolean getLoginStatus() {
        return sharedPreferences.getBoolean("isLoggedIn", false);
    }

}
