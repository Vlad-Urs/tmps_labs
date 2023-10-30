package lab_3.player;

import lab_3.CharacterSkills;
import lab_3.skills.Skill;

public interface Player {
    void addSkill(Skill skill);
    void removeSkill(String skillName);
    void displayPlayer();
    String getName();
    String getRace();

    CharacterSkills getSkills();
}