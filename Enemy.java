public abstract  class Enemy implements Mortal {
    protected String name;    
    protected int health;
    
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

    public synchronized  void  takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0; 
        }
        System.out.println(name + " получил урон: " + damage + ". Осталось здоровья: " + health);
        if (health == 0) {
            if (health == 0) {                     
            System.out.println(name + " побеждён.");
            }
        }        
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }
}
