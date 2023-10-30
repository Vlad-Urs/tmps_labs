package lab_3.player;

import lab_3.CharacterSkills;
import lab_3.EquippableItem;
import lab_3.skills.Skill;

import java.util.Objects;

public class PlayerCharacter implements Player{
    private String name;
    private String race;
    private CharacterSkills skills;



    public PlayerCharacter(String name, String race){
        this.name = name;
        this.race = race;
        this.skills = new CharacterSkills();
    }

    public void displayPlayer(){
        System.out.println("Player Name: " + name);
        System.out.println("Player Race: " + race);
        if (skills != null) {
            skills.showSkills();
        }
        else {
            System.out.println("Player has no skills");
        }
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

    public CharacterSkills getSkills() {
        return skills;
    }

    public void addSkill(Skill skill){
        skills.addSkill(skill);
    }

    public void removeSkill(String skillName){
        skills.removeSkill(skillName);
    }

    public void setSkills(CharacterSkills newSkills) {
        skills = newSkills;
    }

    public void useItem(EquippableItem item){
        for (Skill skill : skills.getSkills()){
            if (Objects.equals(skill.getType(), item.getBoostedSkillType())){
                skill.applyItemBoost(item.getBoostAmount());
                System.out.println("Item buff added");
            }
        }
    }
}
