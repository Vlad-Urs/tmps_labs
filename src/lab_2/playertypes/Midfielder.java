package lab_2.playertypes;

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
