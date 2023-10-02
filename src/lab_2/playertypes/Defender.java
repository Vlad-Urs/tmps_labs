package lab_2.playertypes;

public class Defender implements Player{
    private String name;
    private int goals;
    private int assists;
    private int cleanSheets;
    private Position pos;

    public Defender(String name, Position pos, int goals, int assists, int cleanSheets){
        this.name = name;
        this.pos = pos;
        this.goals = goals;
        this.assists = assists;
        this.cleanSheets = cleanSheets;
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
        cleanSheets = newCleanSheets;
    }

    @Override
    public int getCleanSheets(){
        return cleanSheets;
    }

    @Override
    public String getName() {
        return name;
    }
}
