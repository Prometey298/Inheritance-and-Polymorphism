public class Zombie extends Enemy {

    private static final int INITIAL_HEALTH = 25000;
    //private String name;

    public Zombie(String name) {
        super(INITIAL_HEALTH);
        this.name = name;

    }
    @Override
    public void attackHero(Hero hero) {
        if (!isAlive()) {
            return;
        } 
        int damage = 10;
        System.out.println(name + " кусает!");
        hero.takeDamage(damage);
    }
}