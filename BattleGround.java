

public class BattleGround {
    public static void main(String[] args) {

        Warrior warrior = new Warrior("Гимли");
        Mage mage = new Mage("Гэндальф");
        Archer archer = new Archer("Леголас");

        Enemy enemy = new Enemy(100);
        Thread warriorThread = new Thread(() -> {        
            while (enemy.isAlive()) {
                warrior.attackEnemy(enemy);
                try {
                    Thread.sleep(2000); 
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        Thread mageThread = new Thread(() -> {
            while (enemy.isAlive()) {
                mage.attackEnemy(enemy);
                try {
                    Thread.sleep(1200);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }                        
            }
        });
        Thread archerThread = new Thread(() -> {
            while (enemy.isAlive()) {
                archer.attackEnemy(enemy);
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        
        warriorThread.start();
        mageThread.start();
        archerThread.start();

        try {
            warriorThread.join();
            mageThread.join();
            archerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Враг побеждён.");
    }    
}
