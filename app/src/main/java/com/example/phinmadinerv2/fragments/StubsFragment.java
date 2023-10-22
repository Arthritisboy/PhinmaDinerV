package com.example.phinmadinerv2.fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.example.phinmadinerv2.R;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

import com.example.phinmadinerv2.CaptureActStubs.CaptureAct;

import java.util.HashMap;
import java.util.Map;

public class StubsFragment extends Fragment {

    Button btn_scan;

    TextView points;
    public static final String KEY_USERNAME = "username";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_POINTS = "points";

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_stubs, container, false);

        btn_scan = root.findViewById(R.id.btn_scan);
        points = root.findViewById(R.id.points);
        SharedPreferences sp = getActivity().getSharedPreferences("Login", Context.MODE_PRIVATE);
        points.setText(String.valueOf(sp.getFloat("Points",0)));


        btn_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scanCode();
            }
        });

        return root;
    }
    private void scanCode() {

        ScanOptions options = new ScanOptions();
        options.setPrompt("Volume up to flash on");
        options.setBeepEnabled(true);
        options.setOrientationLocked(true);
        options.setCaptureActivity(CaptureAct.class);
        barLaunch.launch(options);
    }
    ActivityResultLauncher<ScanOptions> barLaunch = registerForActivityResult(new ScanContract(), result ->
    {
        SharedPreferences sp = getActivity().getSharedPreferences("Login", Context.MODE_PRIVATE);

        if(result.getContents() != null) {
            if(result.getContents().equals("5")) {
                SharedPreferences.Editor editor = sp.edit();
                float tv_points = Float.parseFloat(points.getText().toString());
                float pointsToAdd = 5;
                float sumOfPoints = tv_points + pointsToAdd;
                editor.putFloat("Points", sumOfPoints);
                editor.commit();
                points.setText(String.valueOf(sp.getFloat("Points",0)));
                updateDatabasePoints();
                Toast.makeText(getContext(), "Successfully added 5 points!", Toast.LENGTH_SHORT).show();

            } else if (result.getContents().equals("10")) {
                SharedPreferences.Editor editor = sp.edit();
                float tv_points = Float.parseFloat(points.getText().toString());
                float pointsToAdd = 10;
                float sumOfPoints = tv_points + pointsToAdd;
                editor.putFloat("Points", sumOfPoints);
                editor.commit();
                points.setText(String.valueOf(sp.getFloat("Points",0)));
                updateDatabasePoints();
                Toast.makeText(getContext(), "Successfully added 10 points!", Toast.LENGTH_SHORT).show();

            } else if (result.getContents().equals("20")) {
                SharedPreferences.Editor editor = sp.edit();
                float tv_points = Float.parseFloat(points.getText().toString());
                float pointsToAdd = 20;
                float sumOfPoints = tv_points + pointsToAdd;
                editor.putFloat("Points", sumOfPoints);
                editor.commit();
                points.setText(String.valueOf(sp.getFloat("Points",0)));
                updateDatabasePoints();
                Toast.makeText(getContext(), "Successfully added 20 points!", Toast.LENGTH_SHORT).show();

            } else if (result.getContents().equals("30")) {
                SharedPreferences.Editor editor = sp.edit();
                float tv_points = Float.parseFloat(points.getText().toString());
                float pointsToAdd = 30;
                float sumOfPoints = tv_points + pointsToAdd;
                editor.putFloat("Points", sumOfPoints);
                editor.commit();
                points.setText(String.valueOf(sp.getFloat("Points",0)));
                updateDatabasePoints();
                Toast.makeText(getContext(), "Successfully added 30 points!", Toast.LENGTH_SHORT).show();

            } else if (result.getContents().equals("40")) {
                SharedPreferences.Editor editor = sp.edit();
                float tv_points = Float.parseFloat(points.getText().toString());
                float pointsToAdd = 40;
                float sumOfPoints = tv_points + pointsToAdd;
                editor.putFloat("Points", sumOfPoints);
                editor.commit();
                points.setText(String.valueOf(sp.getFloat("Points",0)));
                updateDatabasePoints();
                Toast.makeText(getContext(), "Successfully added 40 points!", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(getContext(), "Invalid Stub Point Value!", Toast.LENGTH_SHORT).show();
            }
        }
    });
    private void updateDatabasePoints(){
        SharedPreferences sp = getActivity().getSharedPreferences("Login", Context.MODE_PRIVATE);
        String Username = sp.getString("Username", "");
        String Email = sp.getString("Email", "");
        float Points = sp.getFloat("Points", 0.0f);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://phinmadiner.000webhostapp.com/updatepoints.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(), ""+error, Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put(KEY_USERNAME, Username);
                map.put(KEY_EMAIL, Email);
                map.put(KEY_POINTS, String.valueOf(Points));
                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
    }
}