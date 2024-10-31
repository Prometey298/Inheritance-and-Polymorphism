// Абстрактный класс Hero представляет героя, участвующего в бою
public abstract class Hero implements Runnable, Mortal {
    protected String name;
    private int health;

    public Hero(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    // Абстрактный метод атаки врага, который будет реализован в каждом конкретном классе героя
    public abstract void attackEnemy(Enemy enemy);

    @Override
    public void run() {
    }

    // Метод получения урона героем
    public synchronized void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
        System.out.println(name + " получил урон: " + damage + ". Осталось здоровья: " + health);
        if (health == 0) {
            System.out.println(name + " погиб");
        }
    }

    // Проверка, жив ли герой
    @Override
    public boolean isAlive() {
        return health > 0;
    }
}