public class Warrior extends Hero {

    public Warrior(String name, int health) {
        super(name, health);

    }
    @Override
    public void attackEnemy(Enemy enemy) {
        if (!isAlive()) {
            return;
        } 
        int damage = 10;
        System.out.println(getName() + " наносит мощный удар мечом!");
        enemy.takeDamage(damage);
    }
}
