package com.example.phinmadinerv2.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.example.phinmadinerv2.R;
import com.example.phinmadinerv2.adapters.DealsFragmentAdapter;
import com.example.phinmadinerv2.models.DealsFragmentModel;

import java.util.ArrayList;

public class DealsFragment extends Fragment {
    RecyclerView recyclerViewDeals;
    ArrayList<DealsFragmentModel> dealsFragmentModelList;
    DealsFragmentAdapter dealsFragmentAdapter;
    RadioGroup radioGroup;

    RadioButton btn_group_meals, btn_merienda, btn_solo;

    boolean check = true;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_deals, container, false);

        recyclerViewDeals = root.findViewById(R.id.recyclerview_deals);
        radioGroup = root.findViewById(R.id.radioGroup);
        dealsFragmentAdapter = new DealsFragmentAdapter(getActivity(), dealsFragmentModelList);
        recyclerViewDeals.setAdapter(dealsFragmentAdapter);
        recyclerViewDeals.setHasFixedSize(true);
        recyclerViewDeals.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerViewDeals.setNestedScrollingEnabled(false);
        btn_group_meals = root.findViewById(R.id.btn_group_meals);
        btn_solo = root.findViewById(R.id.btn_solo);
        btn_merienda = root.findViewById(R.id.btn_merienda);
        if (check) {
            ArrayList<DealsFragmentModel> dealsFragmentModels = new ArrayList<>();
            dealsFragmentModels.add(new DealsFragmentModel(R.drawable.groupulam_1));
            dealsFragmentModels.add(new DealsFragmentModel(R.drawable.groupulam_1));
            dealsFragmentModels.add(new DealsFragmentModel(R.drawable.groupulam_1));
            dealsFragmentModels.add(new DealsFragmentModel(R.drawable.groupulam_1));
            dealsFragmentModels.add(new DealsFragmentModel(R.drawable.groupulam_1));
            dealsFragmentModels.add(new DealsFragmentModel(R.drawable.groupulam_1));
            dealsFragmentModels.add(new DealsFragmentModel(R.drawable.groupulam_1));
            dealsFragmentModels.add(new DealsFragmentModel(R.drawable.groupulam_1));
            dealsFragmentModels.add(new DealsFragmentModel(R.drawable.groupulam_1));
            dealsFragmentModels.add(new DealsFragmentModel(R.drawable.groupulam_1));

            callback(dealsFragmentModels);
            check = false;
        }

        btn_group_meals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<DealsFragmentModel> dealsFragmentModels = new ArrayList<>();
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.groupulam_1));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.groupulam_1));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.groupulam_1));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.groupulam_1));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.groupulam_1));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.groupulam_1));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.groupulam_1));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.groupulam_1));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.groupulam_1));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.groupulam_1));

                callback(dealsFragmentModels);
            }
        });


        btn_solo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<DealsFragmentModel> dealsFragmentModels = new ArrayList<>();
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.ulam_1));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.ulam_1));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.ulam_1));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.ulam_1));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.ulam_1));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.ulam_1));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.ulam_1));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.ulam_1));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.ulam_1));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.ulam_1));

                callback(dealsFragmentModels);
            }
        });


        btn_merienda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<DealsFragmentModel> dealsFragmentModels = new ArrayList<>();
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.meriendadeal_1));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.meriendadeal_1));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.meriendadeal_1));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.meriendadeal_1));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.meriendadeal_1));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.meriendadeal_1));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.meriendadeal_1));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.meriendadeal_1));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.meriendadeal_1));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.meriendadeal_1));

                callback(dealsFragmentModels);
            }
        });

        return root;
    }


    // Inflate the layout for this fragment
    public void callback(ArrayList<DealsFragmentModel> list) {
        dealsFragmentAdapter = new DealsFragmentAdapter(getContext(), list);
        dealsFragmentAdapter.notifyDataSetChanged();
        recyclerViewDeals.setAdapter(dealsFragmentAdapter);
    }
}