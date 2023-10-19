package com.example.phinmadinerv2.models;

public class DealsFragmentModel {
    int dealsImage;
    String dealsName;
    int dealsPoints;
    String dealsPointsString;

    public DealsFragmentModel(int dealsImage, String dealsName, int dealsPoints, String dealsPointsString) {
        this.dealsImage = dealsImage;
        this.dealsName = dealsName;
        this.dealsPoints = dealsPoints;
        this.dealsPointsString = dealsPointsString;
    }

    public int getDealsImage() {
        return dealsImage;
    }

    public String getDealsName() {
        return dealsName;
    }

    public int getDealsPoints() {
        return dealsPoints;
    }

    public String getDealsPointsString() {
        return dealsPointsString;
    }
}
