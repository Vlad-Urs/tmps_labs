package com;

import com.trains.Carriage;
import com.trains.Train;

public class BusinessTicket extends Ticket{

    public BusinessTicket(Train train, Carriage carriage, int seatNumber) {
        super(train, carriage, seatNumber);
    }

    @Override
    public void getDetails() {
        System.out.println("Your train: " + train.getTrainId());
        System.out.println("Your carriage " + carriage.getId());
        System.out.println("Your seat: " + seatNumber);
    }
}
