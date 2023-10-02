package com.trains;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import com.trains.locomotives.Locomotive;

interface showCarriages{
    public void listCarriages();
}


public class Train implements showCarriages{
    private String id;
    private List<Carriage> carriages = new ArrayList<>();
    private Locomotive loco;

    public Train (String id, Locomotive loco){
        this.id = id;
        this.loco = loco;
    }

    public void addCarriage(Carriage newCarriage){
        carriages.add(newCarriage);
    }

    @Override
    public void listCarriages(){
        System.out.println("carriages: ");
        for (Carriage carriage: carriages) {
            System.out.println("Carriage: " + carriage.getId() +
                               "   Type: " + carriage.getType() +
                               "   Capacity: " + carriage.getCapacity());
        }
    }

    public String getTrainId(){
        return id;
    }
}