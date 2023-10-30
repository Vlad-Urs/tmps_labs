# Structural Design Patterns


## Author: Ursu Vlad, FAF-212

----

## Objectives:
1. Study and understand the Structural Design Patterns.

2. As a continuation of the previous laboratory work, think about the functionalities that your system will need to provide to the user.

3. Implement some additional functionalities, or create a new project using structural design patterns.
## Laboratory notes

* A simple project resembling a character creation process in an RPG made in Java.
* 4 structural design patterns were implemented: Facade, Composite, Proxy and Decorator.

## Implementation:

### 1. Facade:

The Character Creation Facade is designed to simplify and streamline the 
process of creating and customizing player characters by providing a unified 
interface. It encapsulates the complexity of character creation, skill addition, 
and skill removal, enabling a more straightforward and intuitive experience for 
players.

```java
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
```

### 2. Composite:
The Composite pattern is applied to manage a collection of skills within a 
character. This pattern allows individual skills and collections of skills to 
be treated uniformly, simplifying the management and display of a character's 
skill set. The "CharacterSkills" class acts as the composite, managing the 
individual "Skill" objects, and the composite pattern enables consistent 
operations, such as adding, removing, and displaying skills, regardless of 
whether they are individual skills or groups of skills.

```java
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
```

### 3. Proxy:
The Proxy pattern is applied to manage access and control to a real 
"PlayerCharacter" object. The proxy serves as a surrogate for the actual 
character, intercepting and managing interactions with the character object. 
It allows for deferred creation of the real player character and the ability 
to perform additional operations, such as skill management and character 
display, when required. This pattern is particularly useful when you want to 
provide a controlled and enhanced interface to an underlying object, enabling 
actions like adding or removing skills, displaying character information, and 
more, while maintaining an extra layer of control over these operations.

```java
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
```

### 4. Decorator:
By implementing equippable items as wrappers/decorators that boost skills 
when used, you can add an extra layer of customization and strategy to your 
RPG character customization project. Players can make choices about which 
items to use to enhance their skills and abilities.

The snippet of code from the PlayerCharacter performs just this, springing to
action when the player equips a special item.
```java
public void useItem(EquippableItem item){
        for (Skill skill : skills.getSkills()){
            if (Objects.equals(skill.getType(), item.getBoostedSkillType())){
                skill.applyItemBoost(item.getBoostAmount());
                System.out.println("Item buff added");
            }
        }
    }
```

---
## Results:

1. The Player is initialized, and all further operations are done using the facade:

```
Enter Player Name: Feanor
Enter Player Race: Elf
-----------------------------------------------------------------------------------------
Player Name: Feanor
Player Race: Elf
Character's Skills:

Choose Option:
1 - Add new magic skill
2 - Add new physical skill
3 - Remove skill
4 - Add proxy to main player
5 - display proxy
6 - Quit skill customization
Option: 
```

2. Creating 2 basic player skills:

```
Player Name: Feanor
Player Race: Elf
Character's Skills:

Choose Option:
1 - Add new magic skill
2 - Add new physical skill
3 - Remove skill
4 - Add proxy to main player
5 - display proxy
6 - Quit skill customization
Option: 1
Input spell name: fireball
Input spell damage: 10
Input spell type: destruction
-----------------------------------------------------------------------------------------
Player Name: Feanor
Player Race: Elf
Character's Skills:

Choose Option:
1 - Add new magic skill
2 - Add new physical skill
3 - Remove skill
4 - Add proxy to main player
5 - display proxy
6 - Quit skill customization
Option: 2
Input attack name: slash
Input attack damage: 8
Input weapon type: short blade
-----------------------------------------------------------------------------------------
Player Name: Feanor
Player Race: Elf
Character's Skills:

Choose Option:
1 - Add new magic skill
2 - Add new physical skill
3 - Remove skill
4 - Add proxy to main player
5 - display proxy
6 - Quit skill customization
Option: 
```

3. As can be seen, the Player is not updated. Instead all the first hand modifications
are done in the proxy. The proxy can be also seen:

```
Option: 5
Proxy:
Player Name: Feanor
Player Race: Elf
Character's Skills:
    Skill Name: fireball
    Damage: 10
    Magic Type: destruction

    Skill Name: slash
    Damage: 8
    Weapon Type: short blade

```

4. Later, the Player can be updated with the data in proxy:

```
Option: 4
-----------------------------------------------------------------------------------------
Player Name: Feanor
Player Race: Elf
Character's Skills:
    Skill Name: fireball
    Damage: 10
    Magic Type: destruction

    Skill Name: slash
    Damage: 8
    Weapon Type: short blade

```

5. After skill customization the character is equipped with a special item and it's stats updated accordingly:

```
Option: 6
Item buff added
Player Name: Feanor
Player Race: Elf
Character's Skills:
    Skill Name: fireball
    Damage: 15
    Magic Type: destruction

    Skill Name: slash
    Damage: 8
    Weapon Type: short blade
```

---
## Conclusion
In this project, there were successfully implemented several design patterns 
to create a flexible and extensible RPG character customization system. The 
key design patterns employed include the Composite, Proxy, Decorator, and Facade 
patterns, each serving a specific role in enhancing the user experience and 
system organization.
