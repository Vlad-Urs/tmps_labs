package lab_3.player;

import lab_3.CharacterSkillsGroup;
import lab_3.skills.Skill;

public class PlayerCharacterProxy implements Player {
    private PlayerCharacter realPlayerCharacter;

    public PlayerCharacterProxy(String name, String race) {

        this.realPlayerCharacter = new PlayerCharacter(name, race);
    }

    @Override
    public void addMagicSkill(Skill skill) {
        if (realPlayerCharacter == null) {
            realPlayerCharacter = new PlayerCharacter(getName(), getRace());
        }
        realPlayerCharacter.addMagicSkill(skill);
    }

    @Override
    public void addPhysicalSKill(Skill skill) {
        if (realPlayerCharacter == null) {
            realPlayerCharacter = new PlayerCharacter(getName(), getRace());
        }
        realPlayerCharacter.addPhysicalSKill(skill);
    }

    @Override
    public void removeSkill(String skillName) {
        if (realPlayerCharacter == null) {
            realPlayerCharacter = new PlayerCharacter(getName(), getRace());
        }
        realPlayerCharacter.removeSkill(skillName);
    }

    @Override
    public void displayPlayer() {
        if (realPlayerCharacter == null) {
            realPlayerCharacter = new PlayerCharacter(getName(), getRace());
        }
        realPlayerCharacter.displayPlayer();
    }

    @Override
    public String getName() {
        return realPlayerCharacter.getName();
    }

    @Override
    public String getRace() {
        return realPlayerCharacter.getRace();
    }

    @Override
    public CharacterSkillsGroup getMagicSkills() {
        return realPlayerCharacter.getMagicSkills();
    }

    @Override
    public CharacterSkillsGroup getPhysicalSkills() {
        return realPlayerCharacter.getPhysicalSkills();
    }


}

