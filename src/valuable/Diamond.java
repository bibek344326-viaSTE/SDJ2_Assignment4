package valuable;

public class Diamond implements Valuable {
    private String name;
    private double value;

    public Diamond() {
        this.name = "Diamond";
        this.value = 50;
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
