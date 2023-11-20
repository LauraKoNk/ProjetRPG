package cours3.rpg;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player extends Destructible
                    implements ActionsPlayer {


    private String name;
    private ArrayList<Weapon> weapons;
    private double money;

    private int damage;
    private static final double HP = 100.;

    private Weapon currentWeapon;


    // Constructeur
    public Player(String name) {
        super(HP);
        this.name = name;
        this.money = 50;
        this.damage = 10;
        this.weapons = new ArrayList<>();
    }

    // Méthode pour récupérer le nom du joueur
    public String getName() {
        return this.name;
    }

    // Méthode pour vérifier si le joueur est mort
    @Override
    public boolean isDead() {
        return getLife() <= 0;
    }

    // Méthode pour récupérer les armes du joueur
    public ArrayList<Weapon> getWeapons() {
        return new ArrayList<>(this.weapons);
    }

    // Méthode pour récupérer l'argent du joueur
    public double getMoney() {
        return this.money;
    }

    // Méthode pour acheter une arme
    @Override
    public void buyWeapon(Weapon w) {
        if (w.getPrice() <= this.money) {
            this.weapons.add(w);
            this.money -= w.getPrice();
            System.out.println(this.name + " has bought a " + w.getName() + " for " + w.getPrice() + "$");
        } else {
            System.out.println("You do not have enough money to buy this! " +
                    "(your money : " + this.money + " - weapon price : " + w.getPrice() + "$");
        }
    }

    // Méthode pour afficher les armes du joueur
    public void displayWeapons() {
        System.out.println("Weapons of " + this.name + ":");
        for (Weapon weapon : weapons) {
            System.out.println(weapon.getName());
        }
    }

    // Méthode pour attaquer un monstre
    public void attackMonster(Monster targetMonster) {
        double targetHP = targetMonster.getLife();
        int damageDealt = calculateDamage();
        targetMonster.hit(damageDealt);

        System.out.println(getName() + " attacks " + targetMonster.getName() + " and inflicts " + damageDealt + " points of damage to it !");

        if (targetMonster.isDead()) {
            System.out.println(targetMonster.getName() + " has been defeated by " + getName() + " !");
        }
    }

    // Méthode pour attaquer un obstacle
    public void attackObstacle(Obstacle targetObstacle) {
        double targetHP = targetObstacle.getLife();
        int damageDealt = calculateDamage();
        targetObstacle.hit(damageDealt);

        System.out.println(getName() + " smash " + targetObstacle.getName() + " and inflicts " + damageDealt + " points of damage to it !");

        if (targetObstacle.isDead()) {
            System.out.println(targetObstacle.getName() + " has been defeated by " + getName() + " !");
        }
    }

    private int calculateDamage() {
        if (damage <= 0) {
            throw new IllegalStateException("La valeur de dégâts (damage) doit être positive.");
        }

        Random random = new Random();

        int playerStrength = random.nextInt(3) + 1;

        int baseDamage = random.nextInt(damage) + 1;
        int totalDamage = baseDamage * playerStrength;

        return totalDamage;
    }

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    public void changeWeapon(Scanner scanner, WeaponStore store) {
        // Affiche les armes disponibles
        System.out.println("Available weapons:");
        store.printWeaponsList();

        // Demande au joueur de choisir une nouvelle arme
        System.out.println("Enter the number of the weapon you want to use:");
        int weaponChoice = scanner.nextInt();

        // Vérifie si le choix est valide
        if (store.isValidWeaponChoice(weaponChoice)) {
            // Met à jour l'arme actuelle du joueur
            currentWeapon = store.getWeapon(weaponChoice - 1); // -1 car la liste est indexée à partir de 0
            System.out.println("You switched to " + currentWeapon.getName() + "!");
        } else {
            System.out.println("Invalid weapon choice. Keeping the current weapon.");
        }
    }



}
