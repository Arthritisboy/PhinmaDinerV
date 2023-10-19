package com.example.phinmadinerv2.models;

public class HomeFragmentModel {
    int homeImage;
    String homeName;

    int homePoints;

    String homePointsString;



    public HomeFragmentModel(int homeImage, String homeName, int homePoints, String homePointsString) {

        this.homeImage = homeImage;
        this.homeName = homeName;
        this.homePoints = homePoints;
        this.homePointsString = homePointsString;
    }

    public int getHomeImage() {

        return homeImage;
    }

    public String getHomeName() {
        return homeName;
    }

    public int getHomePoints() {
        return homePoints;
    }

    public String getHomePointsString() {
        return homePointsString;
    }
}

