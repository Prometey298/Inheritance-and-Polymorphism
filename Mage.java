public class Mage extends Hero {

    public Mage(String name, int health) {
        super(name, health);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        if (!isAlive()) {
            return;
        }        
        int damage = 8;
        System.out.println(getName() + " использует магическое заклинание!");
        enemy.takeDamage(damage);
    }    
}
