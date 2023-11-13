package lab_3.player;

import lab_3.CharacterSkillsGroup;
import lab_3.skills.Skill;

public interface Player {
    void addMagicSkill(Skill skill);

    void addPhysicalSKill(Skill skill);

    void removeSkill(String skillName);
    void displayPlayer();
    String getName();
    String getRace();

    CharacterSkillsGroup getMagicSkills();
    CharacterSkillsGroup getPhysicalSkills();
}