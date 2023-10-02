package com.trains.locomotives;

public class DieselLoco extends Locomotive implements Sounds{
    public DieselLoco(String id, int maxLoad, int maxSpeed){
        super(id, maxLoad, maxSpeed);
    }

    @Override
    public void locoSound(){
        System.out.print("choochoo");
    }
}