package lab_2.playertypes;

public class Forward implements Player{
    private String name;
    private int goals;
    private int assists;
    private int conversionRate;
    private Position pos;

    public Forward(String name, Position pos, int goals, int assists, int rate){
        this.name = name;
        this.pos = pos;
        this.goals = goals;
        this.assists = assists;
        this.conversionRate = rate;
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

    public void setPassAccuracy(int rate) {
        conversionRate = rate;
    }

    public int getPassAccuracy(){
        return conversionRate;
    }
}
