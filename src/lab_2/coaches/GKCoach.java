package lab_2.coaches;

public class GKCoach extends CoachPrototype {
    private String name;
    private String type;
    public GKCoach(String name, String type){
        this.name = name;
        this.type = type;
    }

    @Override
    public void runDrills() {
        System.out.println("Run shuffle dives");
        System.out.println("Run saving agility drill");
        System.out.println("Run gk footwork exercise");
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
