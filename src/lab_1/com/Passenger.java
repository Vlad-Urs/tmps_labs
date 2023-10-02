package com;

import com.trains.Carriage;
import com.trains.Train;

public class Passenger extends User implements reserveTicket{
    private Ticket ticket;

    public Passenger(String id, String name){
        super(id, name);
    }

    @Override
    public void reserveEconomy(Train train, Carriage carriage, int seatNumber) {
        RegisterEconomy ecRegistry = new RegisterEconomy();
        ecRegistry.createTicket(train, carriage, seatNumber);
        ticket = ecRegistry.getTicket();
    }

    @Override
    public void reserveBusiness(Train train, Carriage carriage, int seatNumber) {
        RegisterBusiness buRegistry = new RegisterBusiness();
        buRegistry.createTicket(train, carriage, seatNumber);
        ticket = buRegistry.getTicket();
    }

    public Ticket getTicket(){
        return ticket;
    }
}
