public class Dragon {
    public static int health;
    private int attackPower;
    private int defense;
    private String[] items = {"weapon", "shield", "health potion", null}; // drops dragon can drop

    public Dragon(String dragonType) {
        this.health = (int) (Math.random() * 31) + 20; // random health
        this.attackPower = (int) (Math.random() * 11) + 5; // random attack
        this.defense = (int) (Math.random() * 5) + 1;
    }


    public int getHealth() {
        return health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getDefense() {
        return defense;
    }

    public String[] getItems() {
        return items;
    }

    public void receiveDamage(int damage) {
        health -= damage;
    }

    public String dropItem() {
        return items[(int) (Math.random() * items.length)];
    }

    public static boolean princessFightDragons(Princess princess, Dragon[] dragons) {
        for (Dragon dragon : dragons) {
            System.out.println(ConsoleUtility.CYAN + "\uD83D\uDC64: Princess is facing a " + ConsoleUtility.RED + "dragon" + ConsoleUtility.CYAN + "!");
            Battle.startBattle(princess, dragon); // battle starts

            if (princess.getHealth() <= 0) {
                return false;
            }
        }
        return true;
    }
}
