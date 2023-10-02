package lab_2;

import lab_2.coaches.CoachPrototype;
import lab_2.coaches.FitnessCoach;
import lab_2.coaches.GKCoach;
import lab_2.coaches.SetPieceCoach;
import lab_2.playertypes.Player;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private TeamManager manager;
    private List<Player> players;
    private String name;
    private List<CoachPrototype> coaches;

    public Team(TeamBuilder builder){
        this.name = builder.name;
        this.manager = builder.manager;
        this.players = builder.players;
        this.coaches = builder.coaches;
    }

    public static class TeamBuilder {
        private TeamManager manager;
        private List<Player> players;
        private String name;
        private List<CoachPrototype> coaches;

        public TeamBuilder(String name, TeamManager manager) {
            this.name = name;
            this.manager = manager;
            this.players = new ArrayList<>();
            this.coaches = new ArrayList<>();
        }

        public TeamBuilder addPlayer(Player player){
            players.add(player);
            return this;
        }

        public TeamBuilder addCoach(CoachPrototype coach){
            coaches.add(coach);

            return this;
        }

        public Team build(){
            return new Team(this);
        }
    }

    public String getName(){
        return name;
    }

    public TeamManager getManager(){
        return manager;
    }

    public List<Player> getPlayers(){
        return players;
    }

    public List<CoachPrototype> getCoaches(){
        return coaches;
    }

}
