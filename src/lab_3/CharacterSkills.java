package lab_3;

import lab_3.skills.Skill;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CharacterSkills {
    private final List<Skill> skills = new ArrayList<>();

    public void addSkill(Skill skill) {
        skills.add(skill);
    }

    public void removeSkill(String skillName){
        for (Skill skill : skills){
            if (Objects.equals(skill.getName(), skillName)){skills.remove(skill);}
        }
    }

    public void showSkills() {
        System.out.println("Character's Skills:");
        for (Skill skill : skills) {
            skill.displaySkillInfo();
        }
    }

    public List<Skill> getSkills() {
        return skills;
    }
}
