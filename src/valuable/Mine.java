package valuable;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Mine {
    private static final Map<String, Integer> valuablesMap = new HashMap<>();
    private static final Random random = new Random();

    private Mine() {
    }

    public static synchronized Valuable getValuable() {
        String[] types = {"WoodenCoin", "Jewel", "GoldNugget", "Ruby", "Diamond"};

        // Generate a random index to select a type
        int randomIndex = random.nextInt(types.length);

        // Get the selected type
        String selectedType = types[randomIndex];

        // Increment the count for the selected type
        int count = valuablesMap.getOrDefault(selectedType, 0);
        valuablesMap.put(selectedType, count + 1);


        // Create and return the corresponding Valuable instance
        switch (selectedType) {
            case "WoodenCoin":
                return new WoodenCoin();
            case "Jewel":
                return new Jewel();
            case "GoldNugget":
                return new GoldNugget();
            case "Ruby":
                return new Ruby();
            case "Diamond":
                return new Diamond();
            default:
                throw new RuntimeException("Invalid valuable type: " + selectedType);
        }
    }
}
