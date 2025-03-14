/**
 * Класс Enemy (Враг)
 *
 * ОПИСАНИЕ НА РУССКОМ:
 * 1) В этом классе нужно объявить поля (например, name, health, attackPower).
 * 2) Реализовать конструктор(ы) для инициализации полей.
 * 3) Написать методы:
 *    - attack(Player player): Логика атаки игрока.
 *    - takeDamage(int damage): Уменьшает здоровье врага.
 *    - isAlive(): Возвращает true, если здоровье > 0.
 * 4) Опционально: добавить геттеры/сеттеры, если нужно.
 */
public class Enemy {
     private String name;
     private int health;
     private int attackPower;

     public Enemy(String name, int health, int attackPower) {
         this.name = name;
         this.health = health;
         this.attackPower = attackPower;
     }

     public void attack(Player player) {
         System.out.println(name + " attacked " + player.getName() + " and did " + attackPower + " damage.");
         player.takeDamage(attackPower);
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
    // Optional: добавить любые другие методы, если требуется (например, getName(), getHealth(), и т.д.)
}
