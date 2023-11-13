package lab_3;

import lab_3.skills.Skill;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CharacterSkillsGroup {
    private final List<Skill> skills = new ArrayList<>();
    private String groupName;


    public CharacterSkillsGroup(String groupName) {
        this.groupName = groupName;
    }

    public void addSkill(Skill skill) {
        skills.add(skill);
    }

    public boolean removeSkill(String skillName){
        for (Skill skill : skills){
            if (Objects.equals(skill.getName(), skillName)){
                skills.remove(skill);
                return true;
            }
        }

        return false;
    }

    public void showSkills() {
        System.out.println("Character's " + groupName + " Skills:");

        for (Skill skill : skills) {
            skill.displaySkillInfo();
        }
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public String getGroupName(){return groupName;}
}
