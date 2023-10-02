package com;

import com.trains.Carriage;
import com.trains.Train;

public class RegisterBusiness implements calculatePrice{
    private BusinessTicket ticket;

    public void createTicket(Train train, Carriage carriage, int seatNumber){
        this.ticket = new BusinessTicket(train, carriage, seatNumber);
    }

    public BusinessTicket getTicket(){
        return ticket;
    }

    public double returnPrice(){
        return 100.00;
    }
}
