package lab_3;

import lab_3.player.PlayerCharacter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PlayerCharacter player = initializePlayer(scanner);
        CharacterCreationFacade facade = new CharacterCreationFacade(player.getName(), player.getRace());

        skillsMenu(scanner, player, facade);

        // add a special amulet that buffs up some skills
        EquippableItem destructionAmulet = new EquippableItem("Amulet of Destruction", "destruction", 5);
        player.useItem(destructionAmulet);
        player.displayPlayer();
    }

    public static PlayerCharacter initializePlayer(Scanner scanner) {
        System.out.print("Enter Player Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Player Race: ");
        String race = scanner.nextLine();
        return new PlayerCharacter(name, race);
    }

    public static void skillsMenu(Scanner scanner, PlayerCharacter player, CharacterCreationFacade facade) {
        while (true) {
            System.out.println("-----------------------------------------------------------------------------------------");

            player.displayPlayer();
            System.out.println();
            System.out.println("Choose Option:");
            System.out.println("1 - Add new magic skill");
            System.out.println("2 - Add new physical skill");
            System.out.println("3 - Remove skill");
            System.out.println("4 - Add proxy to main player");
            System.out.println("5 - display proxy");
            System.out.println("6 - Quit skill customization");
            System.out.print("Option: ");

            try {
                int playerInput = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                if (playerInput == 6) {
                    break;
                }

                if (playerInput == 1) {
                    System.out.print("Input spell name: ");
                    String spellName = scanner.nextLine();

                    System.out.print("Input spell damage: ");
                    int spellDamage = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Input spell type: ");
                    String spellType = scanner.nextLine();

                    facade.addMagicSkill(spellName, spellDamage, spellType);
                } else if (playerInput == 2) {
                    System.out.print("Input attack name: ");
                    String attName = scanner.nextLine();

                    System.out.print("Input attack damage: ");
                    int attDamage = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Input weapon type: ");
                    String weaponType = scanner.nextLine();

                    facade.addPhysicalSkill(attName, attDamage, weaponType);
                } else if (playerInput == 3) {
                    System.out.println("Input skill name to be removed: ");
                    String skillName = scanner.nextLine();
                    try {
                        facade.removeSkill(skillName);
                    } catch (Exception e) {
                        System.out.println("No such skill exists");
                    }
                }

                else if (playerInput == 4){
                    player.setMagicSkills(facade.getPlayerProxy().getMagicSkills());
                    player.setPhysicalSkills(facade.getPlayerProxy().getPhysicalSkills());
                }

                else if (playerInput == 5){
                    System.out.println("Proxy:");
                    facade.displayPlayer();
                }

            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine(); // Consume the newline character
            }
        }
    }
}

