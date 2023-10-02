package com;

import com.trains.Carriage;
import com.trains.Train;

abstract class Ticket {
    protected Train train;
    protected Carriage carriage;
    protected int seatNumber;

    public Ticket(Train train, Carriage carriage, int seatNumber) {
        this.train = train;
        this.carriage = carriage;
        this.seatNumber = seatNumber;
    }

    public abstract void getDetails();
    
}

interface calculatePrice {
    double returnPrice();
}
