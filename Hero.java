public abstract  class Hero {
    private String name;

    public Hero(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public abstract  void attackEnemy(Enemy enemy) {
        int damage = 5;
        System.out.println(name + " атакует врага");
        enemy.takeDamage(damage);
    }
}