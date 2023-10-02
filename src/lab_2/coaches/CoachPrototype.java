package lab_2.coaches;

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
