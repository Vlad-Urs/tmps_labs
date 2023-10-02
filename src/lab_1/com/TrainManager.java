package com;

import com.trains.Carriage;
import com.trains.Train;
import com.trains.locomotives.Locomotive;

public class TrainManager extends User implements createTrain, attachCarriage{
    public TrainManager(String id, String name) {
        super(id, name);
    }


    @Override
    public Train buildTrain(String id, Locomotive loco) {
        Train newTrain = new Train(id, loco);
        return newTrain;
    }

    @Override
    public Train addCarriages(Train train, Carriage newCarriage) {
        train.addCarriage(newCarriage);
        return train;
    }
}
