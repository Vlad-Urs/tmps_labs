package com.trains.locomotives;

public class Locomotive {
    protected String id;
    protected int maxLoad;
    protected int maxSpeed;

    public Locomotive(String id, int maxLoad, int maxSpeed){
        this.id = id;
        this.maxLoad = maxLoad;
        this.maxSpeed = maxSpeed;
    }
}

interface Sounds{
    void locoSound();
}




