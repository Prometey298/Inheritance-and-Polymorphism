import java.util.Random;

public class Archer extends Hero {

    private static final int HIGH_DAMAGE = 25;
    private static final int LOW_DAMAGE = 5;
    private static final double CRITICAL_HIT_CHANCE = 0.5; 

    public Archer(String name, int health) {
        super(name, health);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        if (!isAlive()) {
            return;
        }

        Random random = new Random();
        int damage;

        if (random.nextDouble() < CRITICAL_HIT_CHANCE) {
            damage = HIGH_DAMAGE;
            System.out.println(getName() + " наносит критический удар!");
        } else {
            damage = LOW_DAMAGE;
            System.out.println(getName() + " стреляет из лука!");
        }

        enemy.takeDamage(damage);
    }
}