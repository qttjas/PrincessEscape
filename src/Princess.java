public class Princess {
    private int health;
    private int attack;
    private int defense;

    public Princess() {
        this.health = 50;
        this.attack = 10;
        this.defense = 5;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void receiveDamage(int damage) {
        health -= damage;

    }
}

