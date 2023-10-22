package com.example.phinmadinerv2.fragments;

import android.content.Context;
import android.content.SharedPreferences;
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
import android.widget.TextView;

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

    TextView points;

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
        points = root.findViewById(R.id.points);
        SharedPreferences sp = getActivity().getSharedPreferences("Login", Context.MODE_PRIVATE);

        points.setText(String.valueOf(sp.getFloat("Points",0)));

        if (check) {
            ArrayList<DealsFragmentModel> dealsFragmentModels = new ArrayList<>();
            dealsFragmentModels.add(new DealsFragmentModel(R.drawable.deals_group_meals_beef_steak, "Beef Steak w/ 4 Rice & 1L Coke", 41, "41"));
            dealsFragmentModels.add(new DealsFragmentModel(R.drawable.deals_group_meals_burger_steak, "Burger Steak w/ 4 Rice & 1L Coke", 39, "39"));
            dealsFragmentModels.add(new DealsFragmentModel(R.drawable.deals_group_meals_buttered_garlic_shrimp, "Buttered Shrimp w/ 4 Rice & 1L Coke", 42, "42"));
            dealsFragmentModels.add(new DealsFragmentModel(R.drawable.deals_group_meals_chicken_curry, "Chicken Curry w/ 4 Rice & 1L Coke", 38, "38"));
            dealsFragmentModels.add(new DealsFragmentModel(R.drawable.deals_group_meals_fried_chicken, "Fried Chicken w/ 4 Rice & 1L Coke", 38, "38"));
            dealsFragmentModels.add(new DealsFragmentModel(R.drawable.deals_group_meals_grilled_chicken, "Grilled Chicken w/ 4 Rice & 1L Coke", 39, "39"));
            dealsFragmentModels.add(new DealsFragmentModel(R.drawable.deals_group_meals_kare_kare, "Kare-Kare w/ 4 Rice & 1L Coke", 40, "40"));
            dealsFragmentModels.add(new DealsFragmentModel(R.drawable.deals_group_meals_piniyahang_manok, "Pininyahang Manok w/ 4 Rice & 1L Coke", 38, "38"));
            dealsFragmentModels.add(new DealsFragmentModel(R.drawable.deals_group_meals_pork_adobo, "Pork Adobo w/ 4 Rice & 1L Coke", 40, "40"));
            dealsFragmentModels.add(new DealsFragmentModel(R.drawable.deals_group_meals_tortang_talong, "Tortang Talong w/ 4 Rice & 1L Coke", 34, "34"));

            callback(dealsFragmentModels);
            check = false;
        }

        btn_group_meals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<DealsFragmentModel> dealsFragmentModels = new ArrayList<>();
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.deals_group_meals_beef_steak, "Beef Steak w/ 4 Rice & 1L Coke", 41, "41"));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.deals_group_meals_burger_steak, "Burger Steak w/ 4 Rice & 1L Coke", 39, "39"));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.deals_group_meals_buttered_garlic_shrimp, "Buttered Shrimp w/ 4 Rice & 1L Coke", 42, "42"));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.deals_group_meals_chicken_curry, "Chicken Curry w/ 4 Rice & 1L Coke", 38, "38"));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.deals_group_meals_fried_chicken, "Fried Chicken w/ 4 Rice & 1L Coke", 38, "38"));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.deals_group_meals_grilled_chicken, "Grilled Chicken w/ 4 Rice & 1L Coke", 39, "39"));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.deals_group_meals_kare_kare, "Kare-Kare w/ 4 Rice & 1L Coke", 40, "40"));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.deals_group_meals_piniyahang_manok, "Pininyahang Manok w/ 4 Rice & 1L Coke", 38, "38"));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.deals_group_meals_pork_adobo, "Pork Adobo w/ 4 Rice & 1L Coke", 40, "40"));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.deals_group_meals_tortang_talong, "Tortang Talong w/ 4 Rice & 1L Coke", 34, "34"));

                callback(dealsFragmentModels);
            }
        });


        btn_solo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<DealsFragmentModel> dealsFragmentModels = new ArrayList<>();
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.deals_solo_adobo, "Adobo w/ Rice and Coke", 15, "15"));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.deals_solo_adobong_pusit, "Adobong Pusit w/ Rice and Sprite", 15, "15"));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.deals_solo_bangus, "Bangus w/ Rice and Coke", 13, "13"));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.deals_solo_binagoongan, "Binagoongan w/ Rice and Coke", 15, "15"));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.deals_solo_buffalo_wings, "Buffalo Wings w/ Rice and Royal", 14, "14"));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.deals_solo_chicken_afritada, "Chicken Afritada w/ Rice and Sprite", 15, "15"));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.deals_solo_dinakdakan, "Dinakdakan w/ Rice and Coke", 15, "15"));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.deals_solo_dinuguan, "Dinuguan w/ Rice and Sprite", 14, "14"));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.deals_group_meals_fried_chicken, "Fried Chicken w/ Rice and Coke", 13, "13"));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.deals_solo_ginataang_gulay, "Ginataang Gulay w/ Rice and Coke", 12, "12"));

                callback(dealsFragmentModels);
            }
        });


        btn_merienda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<DealsFragmentModel> dealsFragmentModels = new ArrayList<>();
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.deals_merienda_plain_burger, "Burger and Coke", 11, "11"));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.deals_merienda_carbonara, "Carbonara and Sprite", 11, "11"));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.deals_merienda_cheese_burger, "Cheese Burger and Coke", 12, "12"));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.deals_merienda_egg_sandwich, "Egg Sandwich", 11, "11"));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.deals_merienda_french_fries, "French Fries and Mountain Dew", 11, "11"));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.deals_merienda_ginataang_mais, "Ginataang Mais and Absolute", 11, "11"));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.deals_merienda_ilocos_empanada, "Ilocos Empanada and Coke", 11, "11"));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.deals_merienda_pancit_canton, "Pancit Canton and Coke", 11, "11"));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.deals_merienda_spaghetti, "Spaghetti and Coke", 11, "11"));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.deals_merienda_special_palabok, "Special Palabok and Royal", 11, "11"));
                dealsFragmentModels.add(new DealsFragmentModel(R.drawable.deals_merienda_super_sopas, "Super Sopas and Absolute", 11, "11"));

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