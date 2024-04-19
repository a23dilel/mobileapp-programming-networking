package com.example.networking;

import android.location.Location;

@SuppressWarnings("WeakerAccess")
public class Mountain {
    private String id;
    private String name;
    private String type;
    private String location;
    private int size;
    private int cost;

    public Mountain(String id, String name, String type, String location, int size, int cost) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.location = location;
        this.size = size;
        this.cost = cost;
    }

    public String getID() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public String getLocation() {
        return location;
    }
    public String getSize() {
        return size+"";
    }
    public String getCost() {
        return cost+"";
    }

    public void setID(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }
}
