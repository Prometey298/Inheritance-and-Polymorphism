public abstract  class Hero implements Runnable, Mortal {

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

    public abstract void attackEnemy(Enemy enemy);

    @Override
    public void  run() {
    }

    public synchronized  void  takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0; 
        }        
        System.out.println(name + " получил урон: " + damage + ". Осталось здоровья: " + health);
        if (health == 0) {                         
            System.out.println(name + " погиб");
        }
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }
}