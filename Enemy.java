public class Enemy implements Mortal {
    private int health;
    
    public Enemy(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    public synchronized  void  takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0; // Здоровье не может быть отрицательным
        }
        System.out.println("Враг получил урон: " + damage + ". Осталось здоровья: " + health);
    }
    @Override
    public boolean isAlive() {
        return health > 0;
    }
}
