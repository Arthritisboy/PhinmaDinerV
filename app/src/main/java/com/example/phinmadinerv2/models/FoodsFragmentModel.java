package com.example.phinmadinerv2.models;

public class FoodsFragmentModel {
    int foodsImage;
    String foodsName;
    int foodsPoints;
    String foodPointsString;

    public FoodsFragmentModel(int foodsImage, String foodsName, int foodsPoints, String foodsPointsString) {

        this.foodsImage = foodsImage;
        this.foodsName = foodsName;
        this.foodsPoints = foodsPoints;
        this.foodPointsString = foodsPointsString;
    }

    public int getFoodsImage() {

        return foodsImage;
    }

    public String getFoodsName() {
        return foodsName;
    }

    public int getFoodsPoints() {
        return foodsPoints;
    }

    public String getFoodPointsString() {
        return foodPointsString;
    }
}
