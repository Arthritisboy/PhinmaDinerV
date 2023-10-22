package com.example.phinmadinerv2.fragments;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.phinmadinerv2.Login;
import com.example.phinmadinerv2.ProfileFragmentActivity.AboutUsActivity;
import com.example.phinmadinerv2.ProfileFragmentActivity.PrivacyActivity;
import com.example.phinmadinerv2.R;
import com.example.phinmadinerv2.SharedPreferences.SharedPreferencesClass;


public class ProfileFragment extends Fragment {

    Button privacyButton, feedbackButton, aboutUsButton, logOutButton,
            exitButtonLogout, cancelButtonLogout, submitButtonFeedback, cancelButtonFeedback, thanksCancelButton;

    SharedPreferencesClass sharedPreferenceClass;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        privacyButton = root.findViewById(R.id.privacy);
        feedbackButton = root.findViewById(R.id.feedback);
        aboutUsButton = root.findViewById(R.id.about_us);
        logOutButton = root.findViewById(R.id.log_out);
        AlertDialog.Builder logoutDialog = new AlertDialog.Builder(getContext());
        View logoutLayout = LayoutInflater.from(getContext()).inflate(R.layout.logout_dialog_layout, null);
        logoutDialog.setView(logoutLayout);
        logoutDialog.setCancelable(false);
        final AlertDialog dialog = logoutDialog.create();
        AlertDialog.Builder feedbackDialog = new AlertDialog.Builder(getContext());
        View feedbackLayout = LayoutInflater.from(getContext()).inflate(R.layout.feedback_layout, null);
        feedbackDialog.setView(feedbackLayout);
        feedbackDialog.setCancelable(false);
        final AlertDialog dialog1 = feedbackDialog.create();
        AlertDialog.Builder thankDialog = new AlertDialog.Builder(getContext());
        View thankLayout = LayoutInflater.from(getContext()).inflate(R.layout.thank_you_layout, null);
        thankDialog.setView(thankLayout);
        thankDialog.setCancelable(false);
        final AlertDialog dialog2 = thankDialog.create();
        exitButtonLogout = (Button) logoutLayout.findViewById(R.id.btn_logout_exit);
        cancelButtonLogout = (Button) logoutLayout.findViewById(R.id.btn_logout_cancel);
        submitButtonFeedback = (Button) feedbackLayout.findViewById(R.id.submitFeedback);
        cancelButtonFeedback = (Button) feedbackLayout.findViewById(R.id.cancelFeedback);
        thanksCancelButton = (Button) thankLayout.findViewById(R.id.cancel_btn_feedback);
        sharedPreferenceClass = new SharedPreferencesClass(getContext());


        privacyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), PrivacyActivity.class);
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
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        exitButtonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                Intent intent = new Intent(getActivity(), Login.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

        cancelButtonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        feedbackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog1.show();
            }
        });

        cancelButtonFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog1.dismiss();
            }
        });

        submitButtonFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog2.show();

            }
        });

        thanksCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog1.dismiss();
                dialog2.dismiss();
            }
        });

        return root;

    }


}