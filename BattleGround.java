public class BattleGround {
    public static void main(String[] args) {

        Warrior warrior = new Warrior("Гимли", 100);
        Mage mage = new Mage("Гэндальф", 50);
        Archer archer = new Archer("Леголас", 30);

        Zombie zombie1 = new Zombie("zombie 1");
        Zombie zombie2 = new Zombie("zombie 2");
        Zombie zombie3 = new Zombie("zombie 3");

        Thread warriorThread = createHeroThread(warrior, zombie1);
        Thread mageThread = createHeroThread(mage, zombie2);
        Thread archerThread = createHeroThread(archer, zombie3);

        warriorThread.start();
        mageThread.start();
        archerThread.start();

        try {
            warriorThread.join();
            mageThread.join();
            archerThread.join();
        } catch (InterruptedException e) {
            System.err.println("Ошибка при ожидании завершения потока: " + e.getMessage());
        }
    }

    private static Thread createHeroThread(Hero hero, Zombie zombie) {
        return new Thread(() -> {
            while (zombie.isAlive() && hero.isAlive()) {
                
                zombie.attackHero(hero);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.err.println("Поток прерван: " + e.getMessage());
                    Thread.currentThread().interrupt();
                }

                hero.attackEnemy(zombie);

                try {
                    Thread.sleep(hero instanceof Warrior ? 2000 : hero instanceof Mage ? 1200 : 800);
                } catch (InterruptedException e) {
                    System.err.println("Поток прерван: " + e.getMessage());
                    Thread.currentThread().interrupt();
                }
            }
        });
    }
}