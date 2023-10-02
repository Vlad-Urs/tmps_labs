package com;

import com.trains.*;


public class RegisterEconomy implements calculatePrice{
    private EconomyTicket ticket;

    public void createTicket(Train train, Carriage carriage, int seatNumber){
        this.ticket = new EconomyTicket(train, carriage, seatNumber);
    }

    public EconomyTicket getTicket(){
        return ticket;
    }

    public double returnPrice(){
        return 50.00;
    }
}
