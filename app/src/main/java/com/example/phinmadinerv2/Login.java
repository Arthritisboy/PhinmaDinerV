package com.example.phinmadinerv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.phinmadinerv2.Config.Config;
import com.example.phinmadinerv2.SharedPreferences.SharedPreferencesClass;
import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {

    TextInputEditText textInputEditTextUsername, textInputEditTextPassword;
    Button loginButton;
    TextView textViewSignup;
    SharedPreferences sp;

    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";

    String Username, Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        textInputEditTextUsername = findViewById(R.id.username);
        textInputEditTextPassword = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        textViewSignup = findViewById(R.id.signUpHere);
        SharedPreferencesClass sharedPreferenceClass = new SharedPreferencesClass(this);
        sp = getSharedPreferences("Login", Context.MODE_PRIVATE);


        textViewSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignUp.class);
                startActivity(intent);
                finish();
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username, password;


                username = String.valueOf(textInputEditTextUsername.getText());
                password = String.valueOf(textInputEditTextPassword.getText());


                if (!username.equals("") && !password.equals("")) {

                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[2];
                            field[0] = "username";
                            field[1] = "password";

                            //Creating array for data
                            String[] data = new String[2];
                            data[0] = username;
                            data[1] = password;

                            PutData putData = new PutData("https://phinmadiner.000webhostapp.com/login.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    String result = putData.getResult();
                                    if (result.equals("Login Success")) {

                                        //Shared Preference
                                        GetMatchData();

                                        sharedPreferenceClass.saveLoginStatus(true);


                                        //SharedPreferences.Editor editor = sp.edit();
                                        //editor.putString("User", username);
                                        //editor.commit();
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), LandingPage.class);
                                        startActivity(intent);
                                        finish();


                                    } else {
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                            //End Write and Read data with URL
                        }
                    });
                } else {
                    Toast.makeText(getApplicationContext(), "All fields are required!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void GetMatchData() {

        Username = textInputEditTextUsername.getText().toString().trim();
        Password = textInputEditTextPassword.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.MATCHDATA_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.trim().equals("success")) {

                            showJSON(response);

                        } else {

                            showJSON(response);


                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Login.this, ""+error, Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put(KEY_USERNAME, Username);
                map.put(KEY_PASSWORD, Password);
                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void showJSON(String response) {
        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray(Config.JSON_ARRAY);

            for (int i = 0; i < result.length(); i++) {
                JSONObject jo = result.getJSONObject(i);
                String username = jo.getString(Config.KEY_USERNAME);
                String email = jo.getString(Config.KEY_EMAIL);
                String points = jo.getString(Config.KEY_POINTS);

                final HashMap<String, String> employees = new HashMap<>();
                employees.put(Config.KEY_EMAIL, email);
                employees.put(Config.KEY_USERNAME, username);
                employees.put(Config.KEY_POINTS, points);

                list.add(employees);
                sp = getSharedPreferences("Login", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();

                editor.putString("Username", username);
                editor.putString("Points", points);
                editor.putString("Email", email);
                editor.commit();
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}
