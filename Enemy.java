public abstract class Enemy implements Mortal {
    protected String name;
    protected int health;
    protected static final int INITIAL_HEALTH = 25; 
    protected boolean isResurrected = false; 
    protected static final double RESURRECTION_CHANCE = 0.5; 

    public Enemy(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public abstract void attackHero(Hero hero);

    public synchronized void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
            System.out.println(name + " получил урон: " + damage + ". Осталось здоровья: " + health);
            if (!isResurrected && Math.random() < RESURRECTION_CHANCE) {
                resurrect();
            }
            if (health == 0) {
                System.out.println(name + " побеждён.");
            }
        } else {
            System.out.println(name + " получил урон: " + damage + ". Осталось здоровья: " + health);
        }
    }

    private void resurrect() {
        health = INITIAL_HEALTH; 
        isResurrected = true; 
        System.out.println(name + " воскрес из мёртвых!");
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }
}