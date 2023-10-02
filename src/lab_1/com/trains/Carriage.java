package com.trains;

public class Carriage {
    private String id;
    private String type;
    private int capacity;

    public Carriage(String id, String type, int capacity){
        this.id = id;
        this.type = type;
        this.capacity = capacity;
    }

    public String getId(){
        return id;
    }

    public String getType(){
        return type;
    }

    public int getCapacity(){
        return capacity;
    }
}