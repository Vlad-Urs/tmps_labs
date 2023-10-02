package lab_2;

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
