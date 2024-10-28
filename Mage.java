public class Mage extends Hero {

    public Mage(String name) {
        super(name);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        int damage = 8;
        System.out.println(getName() + " использует магическое заклинание!");
        enemy.takeDamage(damage);
    }    
}
