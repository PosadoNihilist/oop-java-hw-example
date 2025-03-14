/**
 * Класс Player (Игрок)
 *
 * ОПИСАНИЕ НА РУССКОМ:
 * 1) В этом классе нужно объявить поля (например, name, health, attackPower).
 * 2) Реализовать конструктор(ы) для инициализации полей.
 * 3) Написать методы:
 *    - attack(Enemy enemy): Логика атаки врага.
 *    - takeDamage(int damage): Уменьшает здоровье игрока.
 *    - isAlive(): Возвращает true, если здоровье > 0.
 * 4) Опционально: добавить геттеры/сеттеры, метод heal() или другие методы по необходимости.
 */
public class Player {
    private String name;
    private int health;
    private int attackPower;

    public Player(String name, int health, int attackPower) {
         this.name = name;
         this.health = health;
         this.attackPower = attackPower;
     }

     public void attack(Enemy enemy) {
         System.out.println(name + " attacked " + enemy.getName() + " and did " + attackPower + " damage.");
         enemy.takeDamage(attackPower);
     }

     public void takeDamage(int damage) {
         health -= damage;
         if(health < 0) {
             health = 0;
         }
         System.out.println(name + " took" + damage + " damage. (HP: " + health + ")");
     }

     public boolean isAlive() {
        return health > 0;
     }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackPower() {
        return attackPower;
    }
    public void heal(int amount) {
        health += amount;
        System.out.println(name + " healed " + amount + " HP. (HP: " + health + ")");
    }

    // Optional: добавить любые другие методы по желанию (например, heal(), getName(), getHealth() и т.д.)
}
