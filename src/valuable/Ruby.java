package valuable;

public class Ruby implements Valuable {
    private String name;
    private double value;

    public Ruby() {
        this.name = "Ruby";
        this.value = 25;
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
