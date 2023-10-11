package com.example.phinmadinerv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.phinmadinerv2.fragments.BentoFragment;
import com.example.phinmadinerv2.fragments.DealsFragment;
import com.example.phinmadinerv2.fragments.HomeFragment;
import com.example.phinmadinerv2.fragments.ProfileFragment;
import com.example.phinmadinerv2.fragments.StubsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class LandingPage extends AppCompatActivity {
        BottomNavigationView bottomNavigationView;


        @Override
        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        replaceFragment(new HomeFragment());

        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.home_bottom_nav) {
                replaceFragment(new HomeFragment());
            } else if (itemId == R.id.deals_bottom_nav) {
                replaceFragment(new DealsFragment());
            } else if (itemId == R.id.profile_bottom_nav) {
                replaceFragment(new ProfileFragment());
            } else if (itemId == R.id.stubs_bottom_nav) {
                replaceFragment(new StubsFragment());
            } else if (itemId == R.id.bento_bottom_nav) {
                replaceFragment(new BentoFragment());
            }
                return true;
        });

    }
        private void replaceFragment (Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}
