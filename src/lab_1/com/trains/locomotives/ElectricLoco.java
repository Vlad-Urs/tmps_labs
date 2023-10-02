package com.trains.locomotives;

public class ElectricLoco extends Locomotive implements Sounds{
    public ElectricLoco(String id, int maxLoad, int maxSpeed){
        super(id, maxLoad, maxSpeed);
    }

    @Override
    public void locoSound(){
        System.out.print("choochoo");
    }
}