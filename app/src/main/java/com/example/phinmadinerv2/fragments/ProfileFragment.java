package com.example.phinmadinerv2.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.phinmadinerv2.Login;
import com.example.phinmadinerv2.ProfileFragmentActivity.AboutUsActivity;
import com.example.phinmadinerv2.ProfileFragmentActivity.FeedbackActivity;
import com.example.phinmadinerv2.ProfileFragmentActivity.PrivacyActivity;
import com.example.phinmadinerv2.R;



public class ProfileFragment extends Fragment {

    Button privacyButton, feedbackButton, aboutUsButton, logOutButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        privacyButton = root.findViewById(R.id.privacy);
        feedbackButton = root.findViewById(R.id.feedback);
        aboutUsButton = root.findViewById(R.id.about_us);
        logOutButton = root.findViewById(R.id.log_out);

        privacyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), PrivacyActivity.class);
                startActivity(intent);
            }
        });

        feedbackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), FeedbackActivity.class);
                startActivity(intent);

            }
        });

        aboutUsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), AboutUsActivity.class);
                startActivity(intent);
            }
        });
        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog1 = new AlertDialog.Builder(getActivity());

                alertDialog1.setTitle("Logout");
                alertDialog1.setMessage("Are you sure you want to logout? ");
                alertDialog1.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getActivity(), Login.class);
                        startActivity(intent);

                    }

                });
                alertDialog1.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                alertDialog1.show();

            }
        });

        return root;

    }


}