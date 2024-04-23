package valuable;

public class WoodenCoin implements Valuable {
    private String name;
    private double value;

    public WoodenCoin() {
        this.name = "WoodenCoin";
        this.value = 1;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getValue() {
        return value;
    }
}
