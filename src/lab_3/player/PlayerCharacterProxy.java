package lab_3.player;

import lab_3.CharacterSkills;
import lab_3.player.PlayerCharacter;
import lab_3.skills.Skill;

public class PlayerCharacterProxy implements Player {
    private PlayerCharacter realPlayerCharacter;

    public PlayerCharacterProxy(String name, String race) {

        this.realPlayerCharacter = new PlayerCharacter(name, race);
    }

    @Override
    public void addSkill(Skill skill) {
        if (realPlayerCharacter == null) {
            realPlayerCharacter = new PlayerCharacter(getName(), getRace());
        }
        realPlayerCharacter.addSkill(skill);
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
    public CharacterSkills getSkills() {
        return realPlayerCharacter.getSkills();
    }
}

