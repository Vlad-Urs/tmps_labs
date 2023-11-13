package lab_3.player;

import lab_3.CharacterSkillsGroup;
import lab_3.EquippableItem;
import lab_3.skills.Skill;

import java.util.Objects;

public class PlayerCharacter implements Player{
    private String name;
    private String race;
    private CharacterSkillsGroup magicSkills;
    private CharacterSkillsGroup physicalSkills;



    public PlayerCharacter(String name, String race){
        this.name = name;
        this.race = race;
        this.magicSkills = new CharacterSkillsGroup("Magic");
        this.physicalSkills = new CharacterSkillsGroup("Physical");
    }

    public void displayPlayer(){
        System.out.println("Player Name: " + name);
        System.out.println("Player Race: " + race);
        magicSkills.showSkills();
        physicalSkills.showSkills();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    //public CharacterSkillsGroup getSkills() {
       // return skills;
    //}

    public void addMagicSkill(Skill skill){
        magicSkills.addSkill(skill);
    }

    public void addPhysicalSKill(Skill skill){
        physicalSkills.addSkill(skill);
    }

    public void removeSkill(String skillName){
        if (!magicSkills.removeSkill(skillName)) {
            physicalSkills.removeSkill(skillName);
        }
    }

    public void setMagicSkills(CharacterSkillsGroup magicSkills) {
        this.magicSkills = magicSkills;
    }

    public void setPhysicalSkills(CharacterSkillsGroup physicalSkills) {
        this.physicalSkills = physicalSkills;
    }

    public int useItem(EquippableItem item){
        for (Skill skill : magicSkills.getSkills()){
            if (Objects.equals(skill.getType(), item.getBoostedSkillType())){
                skill.applyItemBoost(item.getBoostAmount());
                System.out.println("Item buff added");
                return 0;
            }
        }

        for (Skill skill : physicalSkills.getSkills()){
            if (Objects.equals(skill.getType(), item.getBoostedSkillType())){
                skill.applyItemBoost(item.getBoostAmount());
                System.out.println("Item buff added");
                return 0;
            }
        }

        return 0;
    }

    public CharacterSkillsGroup getMagicSkills() {
        return magicSkills;
    }

    public CharacterSkillsGroup getPhysicalSkills() {
        return physicalSkills;
    }


}
