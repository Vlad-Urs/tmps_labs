package lab_3.skills;

public class Magic extends Skill {
    public Magic(String name, int damage, String magicType) {
        super(name, damage, magicType);
    }

    @Override
    public void useSkill() {
        System.out.println("Casting " + name + " magic: " + damage + " damage");
    }

    @Override
    public void displaySkillInfo() {
        super.displaySkillInfo();
        System.out.println("    Magic Type: " + type);
        System.out.println();
    }
}

