public class Battle {

    public static void startBattle(Princess princess, Dragon dragon) {
        System.out.println("\uD83D\uDC64: Battle started against a dragon" + "!");

        while (princess.getHealth() > 0 && dragon.getHealth() > 0) {
            princessAttack(princess, dragon);
            if (dragon.getHealth() > 0) {
                dragonAttack(princess, dragon);
            }
        }

        if (princess.getHealth() <= 0) {
            System.out.println(ConsoleUtility.CYAN + "\uD83D\uDC64: The princess was defeated by the dragons. (IF THE PRINCESS IS DEAD, GAME OVER)");
        } else {
            handleDragonDrop(princess, dragon);
        }
    }

    private static void princessAttack(Princess princess, Dragon dragon) {
        int damageDealt = getRandomDamage(princess.getAttack()) - dragon.getDefense();
        if (damageDealt > 0) {
            dragon.receiveDamage(damageDealt);
            if (dragon.getHealth() > 0) {
                printWithDelay("\uD83D\uDC64: Princess dealt " + damageDealt + " damage to the dragon!", 2);
            } else {
                printWithDelay("\uD83D\uDC64: The dragon has been defeated", 2);
            }
        }
    }

    private static void dragonAttack(Princess princess, Dragon dragon) {
        int damageDealt = getRandomDamage(dragon.getAttackPower()) - princess.getDefense();
        if (damageDealt > 0) {
            princess.receiveDamage(damageDealt);
            printWithDelay("\uD83D\uDC64: The dragon dealt " + damageDealt + " damage to the Princess!", 2);
        } else {
            printWithDelay("\uD83D\uDC64: The dragon's attack had no effect on the Princess's defense!", 2);
        }
    }

    private static int getRandomDamage(int baseDamage) {
        return (int) (Math.random() * 10) + 1 + baseDamage;
    }

    private static void handleDragonDrop(Princess princess, Dragon dragon) {
        String droppedItem = dragon.dropItem();
        if (droppedItem != null) {
            handleItemEffect(princess, droppedItem);
        } else {
            System.out.println("\uD83D\uDC64: The dragon didn't drop any items.");
        }
    }

    private static void handleItemEffect(Princess princess, String droppedItem) {
        if ("sword".equals(droppedItem)) {
            princess.setAttack(princess.getAttack() * 2);
            printWithDelay("\uD83D\uDC64: Princess found a sword! Her attack power has doubled!", 2);
        } else if ("shield".equals(droppedItem)) {
            princess.setDefense(princess.getDefense() + 5);
            printWithDelay("\uD83D\uDC64: Princess found a shield! Her defense has increased!", 2);
        } else if ("health potion".equals(droppedItem)) {
            princess.setHealth(50);
            printWithDelay("\uD83D\uDC64: Princess found a health potion! Her health has been restored!", 2);
        } else {
            printWithDelay("\uD83D\uDC64: Princess found an item, but it has no special effect.", 2);
        }
    }

    private static void printWithDelay(String message, int seconds) {
        System.out.println(message);
        try {
            Thread.sleep(seconds * 1000);  // Convert seconds to milliseconds
        } catch (InterruptedException e) {
            System.out.println("Error during delay: " + e.getMessage());
        }
    }
}
