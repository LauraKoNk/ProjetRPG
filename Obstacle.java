package cours3.rpg;

import java.util.Random;

public class Obstacle extends Destructible {

    private String name;

    private static final double HP = 50.;
    private static final double HP_VARIATION = 20.0;
    public Obstacle(String name) {
        super(generateRandomHP());
        this.name = name;

    }

    private static double generateRandomHP() {
        Random random = new Random();
        double randomVariation = random.nextDouble() * HP_VARIATION;
        return HP + randomVariation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDead() {
        return getLife() <= 0;
    }
}




