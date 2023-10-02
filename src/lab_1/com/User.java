package com;

import com.sun.org.apache.xpath.internal.objects.XString;
import com.trains.Carriage;
import com.trains.Train;
import com.trains.locomotives.Locomotive;

public abstract class User {
    private String id;
    private String name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

}


interface createTrain{
    public Train buildTrain(String id, Locomotive loco);
}

interface attachCarriage{
    public Train addCarriages(Train train, Carriage newCarriage);
}

interface reserveTicket{
    public void reserveEconomy(Train train, Carriage carriage, int seatNumber);
    public void reserveBusiness(Train train, Carriage carriage, int seatNumber);
}
