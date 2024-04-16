package com.example.networking;

@SuppressWarnings("WeakerAccess")
public class Mountain {
    private String name;
    private int mass;
    private int volume;

    public Mountain(String name, int mass, int volume) {
        this.name = name;
        this.mass = mass;
        this.volume = volume;
    }

    public String getName() {
        return name;
    }
    public String getMass() {
        return mass+"";
    }
    public String getVolume() {
        return volume+"";
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setMass(int mass) {
        this.mass = mass;
    }
    public void setVolume(int volume) {
        this.volume = volume;
    }
}
