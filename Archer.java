import java.util.Random;

// Класс Archer наследуется от Hero и представляет лучника с возможностью критического удара
public class Archer extends Hero {
    private static final int HIGH_DAMAGE = 25; // Сила критического удара
    private static final int LOW_DAMAGE = 5;   // Сила обычного удара
    private static final double CRITICAL_HIT_CHANCE = 0.5; // Шанс критического удара

    public Archer(String name, int health) {
        super(name, health);
    }

    // Реализация метода атаки, в котором есть шанс нанести критический удар
    @Override
    public void attackEnemy(Enemy enemy) {
        if (!isAlive()) { // Если герой мертв, он не может атаковать
            return;
        }

        Random random = new Random();
        int damage;

        // Проверка на критический удар
        if (random.nextDouble() < CRITICAL_HIT_CHANCE) {
            damage = HIGH_DAMAGE;
            System.out.println(getName() + " наносит критический удар!");
        } else {
            damage = LOW_DAMAGE;
            System.out.println(getName() + " стреляет из лука!");
        }

        // Нанесение урона врагу
        enemy.takeDamage(damage);
    }
}