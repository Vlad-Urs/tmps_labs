package lab_3.skills;

public abstract class Skill {
    protected String name;
    protected int damage;

    protected String type;

    public Skill(String name, int damage, String type) {
        this.name = name;
        this.damage = damage;
        this.type = type;
    }

    public abstract void useSkill();

    public void displaySkillInfo() {
        System.out.println("    Skill Name: " + name);
        System.out.println("    Damage: " + damage);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void applyItemBoost(int boostAmount) {
        damage += boostAmount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}