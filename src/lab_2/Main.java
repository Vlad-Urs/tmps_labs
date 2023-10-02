package lab_2;

import lab_2.coaches.CoachPrototype;
import lab_2.coaches.FitnessCoach;
import lab_2.coaches.GKCoach;
import lab_2.coaches.SetPieceCoach;
import lab_2.playertypes.Goalkeeper;
import lab_2.playertypes.Player;
import lab_2.playertypes.Position;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        Random rand = new Random();
        TeamManager manager1 = TeamManager.getInstance("Arsene Wenger");

        // Access and display the manager's name
        System.out.println("Manager 1 Name: " + manager1.getName());

        // Change the manager's name
        manager1.setName("New Manager Name");

        // Get another instance to verify that it retains the modified name
        TeamManager manager2 = TeamManager.getInstance("Mikel Arteta");

        // Access and display the modified manager's name
        System.out.println("Manager 2 Name: " + manager2.getName());

        // Verify that manager1 and manager2 are the same instance
        if (manager1 == manager2) {
            System.out.println("Manager 1 and Manager 2 are the same instance (Singleton works).");
        } else {
            System.out.println("Manager 1 and Manager 2 are different instances (Singleton failed).");
        }

        // create some players using the PlayerFactory
        PlayerFactory academy = new PlayerFactory();
        Player goalkeeper = academy.getPlayer("Aaron Ramsdale", Position.GK);
        Player defender1 = academy.getPlayer("William Saliba", Position.DEF);
        Player midfielder1 = academy.getPlayer("Martin Odegaard", Position.MID);
        Player forward1 = academy.getPlayer("Gabriel Jesus", Position.FWD);

        // set some statistics
        goalkeeper.setCleanSheets(rand.nextInt(38));

        defender1.setCleanSheets(goalkeeper.getCleanSheets());
        defender1.setGoals(rand.nextInt(6));

        midfielder1.setAssists(rand.nextInt(38));
        midfielder1.setGoals(rand.nextInt(20));

        forward1.setAssists(rand.nextInt(20));
        forward1.setGoals(rand.nextInt(40));

        // create some coaches
        CoachPrototype coach1 = new FitnessCoach("Sam Wilson", "fitness");
        CoachPrototype coach2 = new GKCoach("Inaki Cana", "goalkeeping");
        CoachPrototype coach3 = new SetPieceCoach("Nicolas Jover","set pieces");

        Team newTeam = new Team
                .TeamBuilder("Arsenal", manager1)
                .addPlayer(goalkeeper)
                .addPlayer(defender1)
                .addPlayer(midfielder1)
                .addPlayer(forward1)
                .addCoach(coach1)
                .addCoach(coach2)
                .addCoach(coach3)
                .build();

        // verifying the team
        System.out.println();
        System.out.println("Team name: " + newTeam.getName());
        System.out.println("Manager: " + newTeam.getManager().getName());
        System.out.println("Players:");
        for (Player player : newTeam.getPlayers()){
            System.out.println("     " + player.getName());
        }
        System.out.println("Coaches:");
        for (CoachPrototype coach : newTeam.getCoaches()){
            System.out.println("     " + coach.getName());
        }


    }
}
