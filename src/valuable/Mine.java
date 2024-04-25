package valuable;

import java.util.Random;

public class Mine {
    public Valuable getValuable() {
        int a = new Random().nextInt(22);
        if (a > 0 && a <= 10) {
            return new WoodenCoin();
        } else if (a > 10 && a <= 15) {
            return new Jewel();
        } else if (a > 15 && a <= 18) {
            return new GoldNugget();
        } else if (a > 18 && a <= 20) {
            return new Ruby();
        } else if (a==21) {
            return new Diamond();
        }
        else throw new RuntimeException("Invalid random generated, hint: check the boundary of the random");

    }
}
