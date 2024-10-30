public class Archer extends Hero {

    public Archer(String name, int health) {
        super(name, health);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        if (!isAlive()) {
            return;
        } 
        int damage = 5;
        System.out.println(getName() + " стреляет из лука!");
        enemy.takeDamage(damage);
    }    
}
