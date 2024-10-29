public abstract  class Hero implements Runnable {
    private String name;

    public Hero(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public abstract void attackEnemy(Enemy enemy);

    @Override
    public void  run() {

    }
}