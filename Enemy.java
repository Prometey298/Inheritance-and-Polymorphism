// Абстрактный класс Enemy представляет врага, с которым будут сражаться герои
public abstract class Enemy implements Mortal {
    protected String name;
    protected int health;
    protected static final int INITIAL_HEALTH = 25; // Начальное здоровье врага
    protected boolean isResurrected = false; // Флаг для проверки, воскрес ли враг
    protected static final double RESURRECTION_CHANCE = 0.5; // Шанс воскресения

    public Enemy(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    // Абстрактный метод атаки героя
    public abstract void attackHero(Hero hero);

    // Метод получения урона и проверка на возможность воскресения
    public synchronized void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
            System.out.println(name + " получил урон: " + damage + ". Осталось здоровья: " + health);
            if (!isResurrected && Math.random() < RESURRECTION_CHANCE) {
                resurrect(); // Вызов метода воскресения
            }
            if (health == 0) {
                System.out.println(name + " побеждён.");
            }
        } else {
            System.out.println(name + " получил урон: " + damage + ". Осталось здоровья: " + health);
        }
    }

    // Метод для воскресения врага с начальным количеством здоровья
    private void resurrect() {
        health = INITIAL_HEALTH;
        isResurrected = true;
        System.out.println(name + " воскрес из мёртвых!");
    }

    // Проверка, жив ли враг
    @Override
    public boolean isAlive() {
        return health > 0;
    }
}