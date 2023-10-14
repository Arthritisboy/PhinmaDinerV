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
import com.example.phinmadinerv2.adapters.FoodsFragmentAdapter;
import com.example.phinmadinerv2.models.FoodsFragmentModel;

import java.util.ArrayList;


public class FoodsFragment extends Fragment {
    RecyclerView recyclerViewFoods;
    ArrayList<FoodsFragmentModel> foodsFragmentModelList;
    FoodsFragmentAdapter foodsFragmentAdapter;
    RadioGroup radioGroup;

    RadioButton btn_dishes, btn_foods_merienda, btn_drinks;

    boolean check = true;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_foods, container, false);

        recyclerViewFoods = root.findViewById(R.id.recyclerview_foods);
        radioGroup = root.findViewById(R.id.radioGroup);
        foodsFragmentAdapter = new FoodsFragmentAdapter(getActivity(), foodsFragmentModelList);
        recyclerViewFoods.setAdapter(foodsFragmentAdapter);
        recyclerViewFoods.setHasFixedSize(true);
        recyclerViewFoods.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerViewFoods.setNestedScrollingEnabled(false);
        btn_dishes = root.findViewById(R.id.btn_dishes);
        btn_drinks = root.findViewById(R.id.btn_drinks);
        btn_foods_merienda = root.findViewById(R.id.btn_merienda_foods);
        if (check) {
            ArrayList<FoodsFragmentModel> foodsFragmentModels = new ArrayList<>();
            foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.groupulam_1));
            foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.groupulam_1));
            foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.groupulam_1));
            foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.groupulam_1));
            foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.groupulam_1));
            foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.groupulam_1));
            foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.groupulam_1));
            foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.groupulam_1));
            foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.groupulam_1));
            foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.groupulam_1));

            callback(foodsFragmentModels);
            check = false;
        }

        btn_dishes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<FoodsFragmentModel> foodsFragmentModels = new ArrayList<>();
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.groupulam_1));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.groupulam_1));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.groupulam_1));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.groupulam_1));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.groupulam_1));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.groupulam_1));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.groupulam_1));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.groupulam_1));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.groupulam_1));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.groupulam_1));

                callback(foodsFragmentModels);
            }
        });


        btn_foods_merienda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<FoodsFragmentModel> foodsFragmentModels = new ArrayList<>();
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_merienda_pancitcanton));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_merienda_burger));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_merienda_cheeseburger));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_merienda_eggsandwich));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_merienda_footlong));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_merienda_frenchfries));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_merienda_ilocosempanada));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_merienda_lumpianggulay));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_merienda_minidonut));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_merienda_porkempanada));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_merienda_siopaoasado));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_merienda_spaghetti));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_merienda_spicypancitcanton));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_merienda_tunapie));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_merienda_turonmalagkit));

                callback(foodsFragmentModels);
            }
        });


        btn_drinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<FoodsFragmentModel> foodsFragmentModels = new ArrayList<>();
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_drinks_bukoshake));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_drinks_coke));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_drinks_kopiko));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_drinks_lemonjuice));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_drinks_mountaindew));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_drinks_nestea));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_drinks_orangejuice));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_drinks_sprite));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_drinks_sting));

                callback(foodsFragmentModels);
            }
        });

        return root;
    }


    // Inflate the layout for this fragment
    public void callback(ArrayList<FoodsFragmentModel> list) {
        foodsFragmentAdapter = new FoodsFragmentAdapter(getContext(), list);
        foodsFragmentAdapter.notifyDataSetChanged();
        recyclerViewFoods.setAdapter(foodsFragmentAdapter);
    }
}