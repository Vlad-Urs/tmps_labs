package lab_3.skills;

public class Physical extends Skill {


    public Physical(String name, int damage, String weaponType) {
        super(name, damage, weaponType);
    }

    @Override
    public void useSkill() {
        System.out.println("Using " + name + " for " + damage);
    }

    @Override
    public void displaySkillInfo() {
        super.displaySkillInfo();
        System.out.println("    Weapon Type: " + type);
        System.out.println();
    }
}
