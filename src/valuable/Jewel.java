package valuable;

public class Jewel implements Valuable {
    private String name;
    private double value;

    public Jewel() {
        this.name = "Jewel";
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
