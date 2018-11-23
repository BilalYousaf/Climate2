package com.bcu.londonappbrewery.climate;

public class HistoryObj {
    String name;
    String temprature;
    String time;

    public HistoryObj(String name, String temprature, String time) {
        this.name = name;
        this.temprature = temprature;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTemprature() {
        return temprature;
    }

    public void setTemprature(String temprature) {
        this.temprature = temprature;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}