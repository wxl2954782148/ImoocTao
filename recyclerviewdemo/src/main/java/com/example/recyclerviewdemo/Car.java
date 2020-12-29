package com.example.recyclerviewdemo;

public class Car {
    private String name;
    private int imageID;

    public Car(String name, int imageID) {
        this.name = name;
        this.imageID = imageID;
    }
    public String getName() {
        return name;
    }
    public int getImageID() {
        return imageID;
    }
}
