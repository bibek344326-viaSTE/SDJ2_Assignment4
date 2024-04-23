package valuable;

public class GoldNugget implements Valuable {
    private String name;
    private double value;

    public GoldNugget() {
        this.name = "GoldNugget";
        this.value = 10;
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
