package lab_2.coaches;

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
