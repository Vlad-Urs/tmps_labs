package lab_2;

import lab_2.playertypes.*;


public class PlayerFactory {
    public Player getPlayer(String name, Position pos){
        if (pos == Position.GK){
            return new Goalkeeper(name, Position.GK,0,0,0);
        }
        if (pos == Position.DEF){
            return new Defender(name, Position.DEF, 0,0,0);
        }
        if (pos == Position.MID){
            return new Midfielder(name, Position.MID, 0,0,0);
        }
        if (pos == Position.FWD){
            return new Forward(name, Position.FWD, 0,0,0);
        }

        return null;
    }
}
