package com.example.demo.models;


public class Topo {

    private String city;
    private String landscape;

    public Topo(String city, String landscape) {
        this.city = city;
        this.landscape = landscape;
    }

    public Topo() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLandscape() {
        return landscape;
    }

    public void setLandscape(String landscape) {
        this.landscape = landscape;
    }

    @Override
    public String toString() {
        return "Topo{" +
                "city='" + city + '\'' +
                ", landscape='" + landscape + '\'' +
                '}';
    }
}
