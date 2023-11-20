package cours3.rpg;

import java.util.Scanner;


public class MainGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a name:");
        String name = scanner.nextLine();
        Player player = new Player(name);
        System.out.println("Player name: " + player.getName());

        WeaponStore store = new WeaponStore();
        store.printWeaponsList();

        System.out.println("Do you want to buy a weapon, " + player.getName() + "? Enter 'yes' or 'no':");

        String buyChoice = scanner.nextLine();
        while (buyChoice.equalsIgnoreCase("yes")) {
            System.out.println("Enter the number of the weapon you want to buy:");
            int weaponChoice = scanner.nextInt();
            if (store.isValidWeaponChoice(weaponChoice)) {
                Weapon selectedWeapon = store.getWeapon(weaponChoice - 1); // -1 because the list is 0-indexed
                player.buyWeapon(selectedWeapon);
                System.out.println("You bought " + selectedWeapon.getName() + "!");

            } else {
                System.out.println("Invalid weapon choice.");
            }

            System.out.println("Do you want to buy another weapon? Enter 'yes' or 'no':");
            buyChoice = scanner.nextLine();
        }


        System.out.println("Your weapons:");
        for (Weapon weapon : player.getWeapons()) {
            System.out.println(weapon.getName());
        }

        while (!player.isDead()) {
            // Décision aléatoire de l'ennemi rencontrer, obstacle ou monstre
            boolean isObstacle = Math.random() < 0.5;
            // Destructible monster;


            Monster monster = null;
            Obstacle obstacle = null;
            if (isObstacle) {
                obstacle = new Obstacle("giant rock");
                System.out.println("[Oh no! You encountered an obstacle!]");
                //Bataille contre l'obstacle
                while (!player.isDead() && !obstacle.isDead()) {
                System.out.println("What do you want to do? Enter 'attack', 'changeWeapon', or 'run':");
                String actionChoice = scanner.next();

                if (actionChoice.equalsIgnoreCase("attack")) {
                    player.attackObstacle(obstacle);
                    System.out.println("[You attacked the obstacle!]");
                    System.out.println("Obstacle's remaining HP: " + obstacle.getLife());
                } else if (actionChoice.equalsIgnoreCase("run")) {
                    System.out.println("[You ran away from the obstacle!]");
                    break;
                } else if (actionChoice.equalsIgnoreCase("changeWeapon")) {
                    // Allow the player to change their weapon
                    player.changeWeapon(scanner, store);
                    System.out.println("[You changed your weapon to " + player.getCurrentWeapon().getName() + "!]");
                } else {
                    System.out.println("Invalid action. Try again.");
                }
            }
            }
            else if (!isObstacle) {
                monster = new Monster("Evil Monster", 15);
                System.out.println("[Warning: A wild " + monster.getName() + " appears!]");
            }

            // Bataille contre le monstre
            while (!player.isDead() && !monster.isDead()) {
                System.out.println("What do you want to do? Enter 'attack', 'changeWeapon', or 'run':");
                String actionChoice = scanner.next();

                if (actionChoice.equalsIgnoreCase("attack")) {
                    player.attackMonster(monster);
                    System.out.println("[You attacked the " + monster.getName() + "!]");
                    System.out.println("Enemy's remaining HP: " + monster.getLife());
                    if (!monster.isDead()) {
                        monster.attack(player);
                        System.out.println("[Watch out! The " + monster.getName() + " counterattacks!]");
                        System.out.println("Your remaining HP: " + player.getLife());
                    }
                } else if (actionChoice.equalsIgnoreCase("run")) {
                    System.out.println("[You ran away from the " + monster.getName() + "!]");
                    break;
                } else if (actionChoice.equalsIgnoreCase("changeWeapon")) {
                    player.changeWeapon(scanner, store);
                    System.out.println("[You changed your weapon to " + player.getCurrentWeapon().getName() + "!]");
                } else {
                    System.out.println("Invalid action. Try again.");
                }
            }

            if (player.isDead()) {
                System.out.println("[Game over! You were defeated. Better luck next time!]");
                break;
            } else {
                System.out.println("[Congratulations! You defeated the " + monster.getName() + "!]");
            }

            // On demande s'il veut continuer le jeu
            System.out.println("Do you want to continue your journey? Enter 'yes' or 'no':");
            String continueChoice = scanner.next();
            if (continueChoice.equalsIgnoreCase("no")) {
                break;
            }
        }
        //remerciements au joueur d'avoir joué
        System.out.println("Thank you for playing!");
    }
}


