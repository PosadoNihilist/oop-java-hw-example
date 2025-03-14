import java.util.Scanner;

/**
 * Класс BattleArena (Основной класс с методом main)
 *
 * ОПИСАНИЕ НА РУССКОМ:
 * 1) В методе main() создаём объект Player и объект Enemy.
 * 2) Организуем логику пошаговой (или цикличной) битвы между игроком и врагом.
 * 3) Можно использовать Scanner для ввода действий игрока:
 *    - Выбор между действиями: атаковать, лечиться, бежать и т.д.
 * 4) Закончить цикл, когда игрок или враг мертвы (health <= 0).
 * 5) Вывести результат битвы.
 */
public class BattleArena {
    public static void main(String[] args) {
        // TODO:
        // Примерные шаги:
        // 1) Спросить у пользователя имя игрока (через Scanner).
        // 2) Создать объект Player (new Player(...)).
        // 3) Создать объект Enemy (new Enemy(...)).
        // 4) Организовать цикл битвы (while player.isAlive() && enemy.isAlive()).
        //    - Спросить у пользователя, что делать:
        //      (1) Атаковать врага, (2) Восстановить здоровье (optional), (3) Сбежать (optional) и т.д.
        //    - Выполнить соответствующие методы (attack, takeDamage).
        //    - Проверить, жив ли игрок/враг, вывести статусы.
        // 5) По окончании цикла вывести победителя или причину завершения игры.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your player name: ");
        String playerName = scanner.nextLine();
        Player player = new Player(playerName, 100, 10);

        Enemy goblin = new Enemy("Small Goblin", 30, 5);

        System.out.println(" A new " + goblin.getName() + " appears with " + goblin.getHealth() + "hp");

        boolean finished = false;
        while (player.isAlive() && goblin.isAlive() && !finished) {
            System.out.println(" \n========== BATTLE MENU ===========");
            System.out.println("1. Attack");
            System.out.println("2. Heal");
            System.out.println("3. Exit game");

            System.out.println(" Choose an action: ");
            int action = scanner.nextInt();

            if (action ==1) {
                player.attack(goblin);
                if (goblin.isAlive()) {
                    goblin.attack(player);
                }
            } else if (action ==2) {
                player.heal(6);
                if (goblin.isAlive()) {
                    goblin.attack(player);
                }
            } else if (action ==3) {
                finished = true;
            }

            if (player.isAlive() && goblin.isAlive() && !finished) {
                System.out.println("\n --- Game State ---");
                System.out.println(player.getName() + "-> HP : " + player.getHealth());
                System.out.println(goblin.getName() + "-> HP : " + goblin.getHealth());
            }
        }

        if (finished) {
            System.out.println("Sad that you left the game :( Come back again!");
        } else {
            if(!player.isAlive()){
                System.out.println("YOU DIED LOL. so baddd");
            } else if (!goblin.isAlive()) {
                System.out.println("YOU WIN. GG EZ :3");
            }
        }
        scanner.close();
    }
}
