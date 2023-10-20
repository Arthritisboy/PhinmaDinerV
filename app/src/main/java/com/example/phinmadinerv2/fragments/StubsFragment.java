package com.example.phinmadinerv2.fragments;

import android.os.Bundle;


import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.phinmadinerv2.R;

public class StubsFragment extends Fragment {

    Button scan_btn_5,scan_btn_10,scan_btn_20,scan_btn_30,scan_btn_40;

    TextView resultPts;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_stubs, container, false);

        scan_btn_5 = root.findViewById(R.id.food_stub_5);
        scan_btn_10 = root.findViewById(R.id.food_stub_10);
        scan_btn_20 = root.findViewById(R.id.food_stub_20);
        scan_btn_30 = root.findViewById(R.id.food_stub_30);
        scan_btn_40 = root.findViewById(R.id.food_stub_40);

        resultPts = root.findViewById(R.id.points);

        scan_btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });


        return root;
    }

}