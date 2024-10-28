public class Warrior extends Hero {

    public Warrior(String name) {
        super(name);
    }
    @Override
    public void attackEnemy(Enemy enemy) {
        int damage = 10;
        System.out.println(getName() + " наносит мощный удар мечом!");
        enemy.takeDamage(damage);
    }
}
