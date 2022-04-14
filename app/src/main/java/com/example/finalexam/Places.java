package com.example.finalexam;

public class Places {
    private String category,capital,pois;
    private double living_cost;
    private int flag,image1;

    public Places() {
        this.category = category;
        this.capital = capital;
        this.pois = pois;
        this.living_cost = living_cost;
        this.flag = flag;
        this.image1 = image1;
    }

    public Places(String category, String capital, String pois, double living_cost, int flag, int image1) {
        this.category = category;
        this.capital = capital;
        this.pois = pois;
        this.living_cost = living_cost;
        this.flag = flag;
        this.image1 = image1;
    }

    public String getCategory() { return category; }

    public void setCategory(String category) { this.category = category; }

    public String getCapital() { return capital; }

    public void setCapital(String capital) { this.capital = capital; }

    public String getPois() { return pois; }

    public void setPois(String pois) { this.pois = pois; }

    public double getLiving_cost() { return living_cost; }

    public void setLiving_cost(double living_cost) { this.living_cost = living_cost; }

    public int getFlag() { return flag; }

    public void setFlag(int flag) { this.flag = flag; }

    public int getImage1() { return image1; }

    public void setImage1(int image1) { this.image1 = image1; }
}
