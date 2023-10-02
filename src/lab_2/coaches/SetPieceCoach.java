package lab_2.coaches;

public class SetPieceCoach extends CoachPrototype{
    private String name;
    private String type;
    public SetPieceCoach(String name, String type){
        this.name = name;
        this.type = type;
    }

    @Override
    public void runDrills() {
        System.out.println("Run attacking free-kick drill");
        System.out.println("Run defending free-kick drill");
        System.out.println("Run corner taking drill");
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
