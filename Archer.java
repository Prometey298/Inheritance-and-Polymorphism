public class Archer extends Hero {

    public Archer(String name) {
        super(name);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        int damage = 5;
        System.out.println(getName() + " стреляет из лука!");
        enemy.takeDamage(damage);
    }    
}
