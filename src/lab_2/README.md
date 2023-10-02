# Creational Design Patterns


## Author: Ursu Vlad, FAF-212

----

## Objectives:
1. Study and understand the Creational Design Patterns.
2. Choose a domain, define its main classes/models/entities and choose the appropriate instantiation mechanisms.
3. Use some creational design patterns for object instantiation in a sample project.

## Laboratory notes

* A simple project resembling a football team manager game or application made in Java.
* The most important components are those of a normal football club: Manager, Players and Coaches.
* 4 creational design patterns were implemented: Singleton, Factory, Prototype and Builder.

## Implementation:

### 1. Singleton design pattern:

What the Singleton aims to do is to keep in check the initialization of objects of a certain class, 
by ensuring that only one instance of that object exists.

Because he is unique, the TeamManager class is structured as a Singleton:

```
public class TeamManager {

    private String name;
    private TeamManager(String name) {
        this.name = name;
    }

    private static class TeamManagerHolder {
        public static final lab_2.TeamManager instance = new lab_2.TeamManager("Default name");
    }

    public static TeamManager getInstance(String name){
        TeamManagerHolder.instance.setName(name);
        return TeamManagerHolder.instance;
    }

    public String getName(){
        return name;
    }

    public void setName(String newName){
        name = newName;
    }
}
```

### 2. Factory Design Pattern:
To create multiple players, the factory design pattern is implemented. 
A factory DP defines an interface for creating an object, but let subclasses decide which class to instantiate.

Firstly a Player interface is created:

```
public interface Player {
    public void setGoals(int newGoals);
    public int getGoals();
    public void setAssists(int newAssists);
    public int getAssists();

    public void setCleanSheets(int newCleanSheets);
    public int getCleanSheets();
    public String getName();

}

```

Afterwards, four different subclasses that implement this interface are created,
each according a player's position on the field, for example there is the Midfielder class:

```
public class Midfielder implements Player{
    private String name;
    private int goals;
    private int assists;
    private int cleanSheets;
    private Position pos;

    public Midfielder(String name, Position pos, int goals, int assists, int sheets){
        this.name = name;
        this.pos = pos;
        this.goals = goals;
        this.assists = assists;
        this.cleanSheets = sheets;
    }
    @Override
    public void setGoals(int newGoals) {
        goals = newGoals;
    }

    @Override
    public int getGoals() {
        return goals;
    }

    @Override
    public void setAssists(int newAssists) {
        assists = newAssists;
    }

    @Override
    public int getAssists() {
        return assists;
    }

    @Override
    public void setCleanSheets(int newCleanSheets) {

    }

    @Override
    public int getCleanSheets() {
        return 0;
    }

    @Override
    public String getName() {
        return name;
    }

}
```

Finally, the PlayerFactory class is created, returning new players according to the position given:

```
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
```

### 3. Prototype Design Pattern:

The concept is to copy an existing object rather than creating a new instance 
from scratch, something that may include costly operations. The existing object
acts as a prototype and contains the state of the object. The newly copied object may change same properties only if required.

To try and demonstrate this, a CoachPrototype abstract class was created:

```
public abstract class CoachPrototype implements Cloneable{
    private String name;
    private String type;



    public Object clone(){
        Object clone = null;
        try{
            clone = super.clone();
        }
        catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return clone();
    }

    public abstract void runDrills();

    public abstract String getName();
    public abstract String getType();
}

```

And extending this prototype, there are 3 different types of coaches, GoalKeeping, Fitness and SetPieces. For example:

```
public class FitnessCoach extends CoachPrototype {
    private String name;
    private String type;
    public FitnessCoach(String name, String type){
        this.name = name;
        this.type = type;
    }

    @Override
    public void runDrills() {
        System.out.println("Run Tic-tac-toe warm-up");
        System.out.println("Run speed and reaction drill");
        System.out.println("Run 1v1 speed and reaction drill");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
     public String getType() {
        return type;
    }
}
```


### 4. Builder Design Pattern:

The builder designed to deal with the construction of comparatively complex objects.
This is why it is constructed to handle the team creation:

```
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
```

---

## Conclusion:

In this laboratory work 4 creational design patterns were implemented, and the
code was successfully tested in a simple creation of a team:

```
anager 1 Name: Arsene Wenger
Manager 2 Name: Mikel Arteta
Manager 1 and Manager 2 are the same instance (Singleton works).

Team name: Arsenal
Manager: Mikel Arteta
Players:
     Aaron Ramsdale
     William Saliba
     Martin Odegaard
     Gabriel Jesus
Coaches:
     Sam Wilson
     Inaki Cana
     Nicolas Jover
```