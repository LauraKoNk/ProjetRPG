package cours3.rpg;

public class Hammer extends Weapon{

    private static final double DAMAGE = 20;
    private static final double PRICE = 10;

    static final double MONSTER_DAMAGE_RATIO = 0.8;
    static final double OBSTACLE_DAMAGE_RATIO = 1.2;

    public Hammer() {
        super("Hammer", DAMAGE, PRICE);
    }

    @Override
    public String ascii_art() {
        return
                "             +-+\n" +
                "=============| |\n" +
                "            `:_;'";
    }

    public static double getDamageRatio(Destructible d) {
        if (d instanceof Monster) {
            return MONSTER_DAMAGE_RATIO;
        } else if (d instanceof Obstacle) {
            return OBSTACLE_DAMAGE_RATIO;
        } else {
            return 1.;
        }
    }
    public void attack(Destructible d) {
        d.hit(this.damage * getDamageRatio(d));
    }
}
