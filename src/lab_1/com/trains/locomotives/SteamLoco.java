package com.trains.locomotives;

public class SteamLoco extends Locomotive implements Sounds{
    public SteamLoco(String id, int maxLoad, int maxSpeed){
        super(id, maxLoad, maxSpeed);
    }

    @Override
    public void locoSound(){
        System.out.print("choochoo");
    }
}