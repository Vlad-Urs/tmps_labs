package lab_3;

import lab_3.player.PlayerCharacterProxy;
import lab_3.skills.Magic;
import lab_3.skills.Physical;

public class CharacterCreationFacade {

    private PlayerCharacterProxy playerProxy;

    public CharacterCreationFacade(String name, String race) {
        this.playerProxy = new PlayerCharacterProxy(name, race);
    }

    public void addMagicSkill(String spellName, int spellDamage, String spellType) {
        Magic newSpell = new Magic(spellName, spellDamage, spellType);
        playerProxy.addSkill(newSpell);
    }

    public void addPhysicalSkill(String attName, int attDamage, String weaponType) {
        Physical newPhys = new Physical(attName, attDamage, weaponType);
        playerProxy.addSkill(newPhys);
    }

    public void removeSkill(String skillName) {
        playerProxy.removeSkill(skillName);
    }

    public PlayerCharacterProxy getPlayerProxy(){
        return playerProxy;
    }

    public void displayPlayer() {
        playerProxy.displayPlayer();
    }
}