public class TrainingGround {
    public static void main(String[] args) {

        Warrior warrior = new Warrior("Гимли");
        Mage mage = new Mage("Гэндальф");
        Archer archer = new Archer("Леголас");

        Enemy enemy = new Enemy(100);
        
        warrior.attackEnemy(enemy);
        mage.attackEnemy(enemy);
        archer.attackEnemy(enemy);  

        System.out.println("Осталось здоровье врага: " + enemy.getHealth());
    }    
}
