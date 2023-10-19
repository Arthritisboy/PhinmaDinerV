package com.example.phinmadinerv2.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.phinmadinerv2.R;
import com.example.phinmadinerv2.adapters.HomeFragmentAdapter;
import com.example.phinmadinerv2.models.HomeFragmentModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment {


    HomeFragmentAdapter homeFragmentAdapter;
    ArrayList<HomeFragmentModel> homeFragmentModelList;

    RecyclerView recyclerViewHome;
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerViewHome = root.findViewById(R.id.recyclerview_home);
        homeFragmentModelList = new ArrayList<>();
        homeFragmentModelList.add(new HomeFragmentModel(R.drawable.home_adobong_pusit,"Regular Adobong Pusit", 10, "10"));
        homeFragmentModelList.add(new HomeFragmentModel(R.drawable.home_bangus_sinigang,"Regular Bangus Sinigang", 9, "9"));
        homeFragmentModelList.add(new HomeFragmentModel(R.drawable.home_bulalo,"Regular Bulalo", 11, "11"));
        homeFragmentModelList.add(new HomeFragmentModel(R.drawable.home_chicken_afritada,"Regular Chicken Afritada", 10, "10"));
        homeFragmentModelList.add(new HomeFragmentModel(R.drawable.home_dinuguan,"Regular Dinuguan", 10, "10"));
        homeFragmentModelList.add(new HomeFragmentModel(R.drawable.home_lugaw,"Regular Lugaw", 6, "6"));
        homeFragmentModelList.add(new HomeFragmentModel(R.drawable.home_pochero,"Regular Pochero", 10, "10"));
        homeFragmentModelList.add(new HomeFragmentModel(R.drawable.home_pork_sinigang,"Regular Pork Sinigang", 11, "11"));
        homeFragmentModelList.add(new HomeFragmentModel(R.drawable.home_shanghai,"Regular Shanghai", 8, "8"));
        homeFragmentModelList.add(new HomeFragmentModel(R.drawable.home_sopas,"Regular Sopas", 6, "6"));
        homeFragmentModelList.add(new HomeFragmentModel(R.drawable.home_tinolang_manok,"Regular Tinolang Manok", 9, "9"));
        homeFragmentModelList.add(new HomeFragmentModel(R.drawable.home_tokwat_baboy,"Regular Tokwa't Baboy", 12, "12"));

        homeFragmentAdapter = new HomeFragmentAdapter(getActivity(),homeFragmentModelList);
        recyclerViewHome.setAdapter(homeFragmentAdapter);
        recyclerViewHome.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerViewHome.setHasFixedSize(true);
        recyclerViewHome.setNestedScrollingEnabled(false);


        // Inflate the layout for this fragment
        return root;
    }
}