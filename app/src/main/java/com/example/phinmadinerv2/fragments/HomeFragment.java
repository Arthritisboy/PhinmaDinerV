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
        homeFragmentModelList.add(new HomeFragmentModel(R.drawable.ulam_1));
        homeFragmentModelList.add(new HomeFragmentModel(R.drawable.ulam_1));
        homeFragmentModelList.add(new HomeFragmentModel(R.drawable.ulam_1));
        homeFragmentModelList.add(new HomeFragmentModel(R.drawable.ulam_1));
        homeFragmentModelList.add(new HomeFragmentModel(R.drawable.ulam_1));
        homeFragmentModelList.add(new HomeFragmentModel(R.drawable.ulam_1));
        homeFragmentModelList.add(new HomeFragmentModel(R.drawable.ulam_1));
        homeFragmentModelList.add(new HomeFragmentModel(R.drawable.ulam_1));
        homeFragmentModelList.add(new HomeFragmentModel(R.drawable.ulam_1));
        homeFragmentModelList.add(new HomeFragmentModel(R.drawable.ulam_1));
        homeFragmentModelList.add(new HomeFragmentModel(R.drawable.ulam_1));
        homeFragmentModelList.add(new HomeFragmentModel(R.drawable.ulam_1));

        homeFragmentAdapter = new HomeFragmentAdapter(getActivity(),homeFragmentModelList);
        recyclerViewHome.setAdapter(homeFragmentAdapter);
        recyclerViewHome.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerViewHome.setHasFixedSize(true);
        recyclerViewHome.setNestedScrollingEnabled(false);


        // Inflate the layout for this fragment
        return root;
    }
}