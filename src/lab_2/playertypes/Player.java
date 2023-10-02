package lab_2.playertypes;

public interface Player {
    public void setGoals(int newGoals);
    public int getGoals();
    public void setAssists(int newAssists);
    public int getAssists();

    public void setCleanSheets(int newCleanSheets);
    public int getCleanSheets();
    public String getName();

}
