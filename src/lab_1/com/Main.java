package com;

import com.trains.Carriage;
import com.trains.Train;
import com.trains.locomotives.Locomotive;


public class Main {

    public static void main(String[] args){
        // creating a new train using the TrainManager and a Locomotive
        Locomotive thomas = new Locomotive("L001", 10, 60);
        TrainManager fatConductor = new TrainManager("M001", "Fat Conductor");
        Train newTrain = fatConductor.buildTrain("T001", thomas);

        // Add 2 new carriages using the TrainManager
        Carriage ecCarriage = new Carriage("C001", "Economy", 40);
        Carriage buCarriage = new Carriage("C002", "Business", 20);
        newTrain = fatConductor.addCarriages(newTrain, ecCarriage);
        newTrain = fatConductor.addCarriages(newTrain, buCarriage);

        Passenger newPassenger = new Passenger("P001", "Piston McTrain");
        newTrain.listCarriages();
        newPassenger.reserveEconomy(newTrain, ecCarriage, 11);
        newPassenger.getTicket().getDetails();
    }
}
