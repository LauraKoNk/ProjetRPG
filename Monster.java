package cours3.rpg;
import java.util.Random;

public class Monster extends Destructible {
    private String name;
    private int damage;
    private static final double HP = 100.;

    public Monster(String name, int damage) {
        super(HP);
        this.name = name;
        this.damage = damage;
    }

    // Méthode pour attaquer le joueur
    public void attack(Player player) {
        double playerHP = player.getLife();
        int damageDealt = calculateDamage();
        player.hit(damageDealt);

        System.out.println(name + " attacks " + player.getName() + " and inflicts " + damageDealt + " points of damage to that poor player !");

        if (player.isDead()) {
            System.out.println(player.getName() + " has been defeated by " + name + " !");
        }
    }

    // Méthode pour calculer les dégâts infligés par le monstre
    private int calculateDamage() {
        Random random = new Random();

        // Facteur aléatoire de force du monstre (1 à 3)
        int monsterStrength = random.nextInt(3) + 1;

        // Calcul des dégâts en utilisant la force du monstre
        int baseDamage = random.nextInt(damage) + 1;
        int totalDamage = baseDamage * monsterStrength;

        return totalDamage;
    }

    // Méthode pour vérifier si le monstre est mort
    public boolean isDead() {
        return getLife() <= 0;
    }

    // Getters et setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

}
