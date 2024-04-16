package com.example.networking;

@SuppressWarnings("WeakerAccess")
public class Mountain {
    private String id;
    private String name;
    private String type;

    public Mountain(String id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
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

    public void setID(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setType(String type) {
        this.type = type;
    }
}
