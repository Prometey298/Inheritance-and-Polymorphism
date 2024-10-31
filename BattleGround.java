// Основной класс для запуска боя между героями и зомби
public class BattleGround {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Гимли", 100);    // Создаем героя-воина
        Mage mage = new Mage("Гэндальф", 50);           // Создаем героя-мага
        Archer archer = new Archer("Леголас", 30);      // Создаем героя-лучника

        Zombie zombie1 = new Zombie("zombie 1"); // Создаем первого зомби
        Zombie zombie2 = new Zombie("zombie 2"); // Создаем второго зомби
        Zombie zombie3 = new Zombie("zombie 3"); // Создаем третьего зомби

        // Создаем потоки для каждого героя, чтобы они атаковали зомби параллельно
        Thread warriorThread = createHeroThread(warrior, zombie1);
        Thread mageThread = createHeroThread(mage, zombie2);
        Thread archerThread = createHeroThread(archer, zombie3);

        // Запускаем потоки
        warriorThread.start();
        mageThread.start();
        archerThread.start();

        try {
            // Ожидание завершения всех потоков
            warriorThread.join();
            mageThread.join();
            archerThread.join();
        } catch (InterruptedException e) {
            System.err.println("Ошибка при ожидании завершения потока: " + e.getMessage());
        }
    }

    // Метод для создания потока для героя, сражающегося с зомби
    private static Thread createHeroThread(Hero hero, Zombie zombie) {
        return new Thread(() -> {
            // Пока оба живы, герой и зомби атакуют друг друга
            while (zombie.isAlive() && hero.isAlive()) {
                zombie.attackHero(hero); // Зомби атакует героя

                try {
                    Thread.sleep(500); // Пауза после атаки зомби
                } catch (InterruptedException e) {
                    System.err.println("Поток прерван: " + e.getMessage());
                    Thread.currentThread().interrupt();
                }

                hero.attackEnemy(zombie); // Герой атакует зомби

                try {
                    // Пауза перед следующей атакой, зависящая от типа героя
                    Thread.sleep(hero instanceof Warrior ? 2000 : hero instanceof Mage ? 1200 : 800);
                } catch (InterruptedException e) {
                    System.err.println("Поток прерван: " + e.getMessage());
                    Thread.currentThread().interrupt();
                }
            }
        });
    }
}