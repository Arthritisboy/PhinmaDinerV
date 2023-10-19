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
            foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_dishes_beef_steak, "Regular Beef Steak", 12, "12"));
            foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_dishes_bicol_express, "Regular Bicol Express", 10, "10"));
            foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_dishes_binagoongan, "Regular Binagoongan", 10, "10"));
            foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_dishes_buffalo_wings, "Regular Buffalo Wings", 10, "10"));
            foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_dishes_buttered_garlic_shrimp, "Regular Buttered Garlic Shrimp", 12, "12"));
            foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_dishes_chicken_curry, "Regular Chicken Curry", 10, "10"));
            foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_dishes_ginataang_gulay, "Regular Ginataang Gulay", 10, "10"));
            foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_dishes_igado, "Regular Igado", 10, "10"));
            foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_dishes_kare_kare, "Regular Kare-Kare", 10, "10"));
            foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_dishes_menudo, "Regular Menudo", 10, "10"));
            foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_dishes_munggo, "Regular Munggo", 10, "10"));
            foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_dishes_tortang_talong, "Regular Tortang Talong", 10, "10"));

            callback(foodsFragmentModels);
            check = false;
        }

        btn_dishes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<FoodsFragmentModel> foodsFragmentModels = new ArrayList<>();
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_dishes_beef_steak, "Regular Beef Steak", 12, "12"));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_dishes_bicol_express, "Regular Bicol Express", 10, "10"));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_dishes_binagoongan, "Regular Binagoongan", 10, "10"));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_dishes_buffalo_wings, "Regular Buffalo Wings", 10, "10"));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_dishes_buttered_garlic_shrimp, "Regular Buttered Garlic Shrimp", 12, "12"));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_dishes_chicken_curry, "Regular Chicken Curry", 10, "10"));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_dishes_ginataang_gulay, "Regular Ginataang Gulay", 10, "10"));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_dishes_igado, "Regular Igado", 10, "10"));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_dishes_kare_kare, "Regular Kare-Kare", 10, "10"));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_dishes_menudo, "Regular Menudo", 10, "10"));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_dishes_munggo, "Regular Munggo", 10, "10"));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_dishes_tortang_talong, "Regular Tortang Talong", 10, "10"));

                callback(foodsFragmentModels);
            }
        });


        btn_foods_merienda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<FoodsFragmentModel> foodsFragmentModels = new ArrayList<>();
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_merienda_burger, "Regular Burger", 6, "6"));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_merienda_cheeseburger, "Regular Cheese Burger", 7, "7"));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_merienda_eggsandwich, "Regular Egg Sandwich", 5, "5"));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_merienda_porkempanada, "Regular Pork Empanada", 5, "5"));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_merienda_frenchfries, "Regular French Fries", 5, "5"));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_merienda_ilocosempanada, "Regular Ilocos Empanada", 6, "6"));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_merienda_lumpianggulay, "Regular Lumpiang Gulay", 4, "4"));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_merienda_minidonut, "Regular Mini Doughnut", 4, "4"));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_merienda_pancitcanton, "Regular Pancit Canton", 8, "8"));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_merienda_footlong, "Regular Footlong", 7, "7"));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_merienda_siopaoasado, "Regular Siopao Asado", 5, "5"));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_merienda_spaghetti, "Regular Spaghetti", 6, "6"));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_merienda_spicypancitcanton, "Regular Spicy Pancit Canton", 6, "6"));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_merienda_turonmalagkit, "Regular Turon Malagkit", 4, "4"));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_merienda_tunapie, "Regular Tuna Pie", 5, "5"));

                callback(foodsFragmentModels);
            }
        });


        btn_drinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<FoodsFragmentModel> foodsFragmentModels = new ArrayList<>();
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_drinks_bukoshake, "Regular Buko Shake", 7, "7"));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_drinks_coke, "Regular Coke", 5, "5"));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_drinks_kopiko, "Regular Kopiko", 4, "4"));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_drinks_lemonjuice, "Regular Lemon Juice", 5, "5"));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_drinks_mountaindew, "Regular Mountain Dew", 5, "5"));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_drinks_nestea, "Regular Nestea", 7, "7"));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_drinks_orangejuice, "Regular Orange Juice", 4, "4"));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_drinks_sprite, "Regular Sprite", 5, "5"));
                foodsFragmentModels.add(new FoodsFragmentModel(R.drawable.foods_drinks_sting, "Regular Sting", 5, "5"));

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