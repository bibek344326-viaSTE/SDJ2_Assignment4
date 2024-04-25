package treasureroom;
import logger.Log;
import valuable.Valuable;
import valuable.Ruby;
import valuable.Jewel;
import valuable.Diamond;
import valuable.GoldNugget;
import valuable.WoodenCoin;

import java.util.ArrayList;

public class TreasureRoom implements Door {
    private ArrayList<Valuable> valuables;
    private Log logger;

    public TreasureRoom() {
        this.valuables = new ArrayList<>();
        this.logger = Log.getInstance();
    }

    public void add(Valuable valuable) {
        valuables.add(valuable);
    }

    public Valuable takeOut() throws Exception {
        if (valuables.isEmpty()) {
            throw new Exception("Safe is empty");
        }
        return valuables.remove(0);
    }

    public void countValuables() {
        int countWoodenCoins = 0;
        int countRubies = 0;
        int countJewels = 0;
        int countGoldNuggets = 0;
        int countDiamonds = 0;
        int woodenCoinsValue = 0;
        int rubiesValue = 0;
        int jewelsValue = 0;
        int goldNuggetsValue = 0;
        int diamondsValue = 0;

        for (Valuable valuable : valuables) {
            if (valuable instanceof WoodenCoin) {
                countWoodenCoins++;
                woodenCoinsValue += valuable.getValue();
            } else if (valuable instanceof Ruby) {
                countRubies++;
                rubiesValue += valuable.getValue();
            } else if (valuable instanceof Jewel) {
                countJewels++;
                jewelsValue += valuable.getValue();
            } else if (valuable instanceof GoldNugget) {
                countGoldNuggets++;
                goldNuggetsValue += valuable.getValue();
            } else if (valuable instanceof Diamond) {
                countDiamonds++;
                diamondsValue += valuable.getValue();
            }
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        logger.log("\t\t\tNumber of Wooden Coins: " + countWoodenCoins + "\tWooden Coins Value: " + woodenCoinsValue +
                "\n\t\t\tNumber of Rubies: " + countRubies + "\tRubies Value: " + rubiesValue +
                "\n\t\t\tNumber of Jewels: " + countJewels + "\tJewels Value: " + jewelsValue +
                "\n\t\t\tNumber of Gold Nuggets: " + countGoldNuggets + "\tGold Nuggets Value: " + goldNuggetsValue +
                "\n\t\t\tNumber of Diamonds: " + countDiamonds + "\tDiamonds Value: " + diamondsValue);
    }
    @Override
    public void acquireRead() {
        // This method is implemented by the genius guard. Have absolutely no idea what to do here....todo ASK TROELS....
    }

    @Override
    public void acquireWrite() {
        // This method is implemented by the genius guard. Have absolutely no idea what to do here....todo ASK TROELS....
    }

    @Override
    public void releaseRead() {
        // This method is implemented by the genius guard. Have absolutely no idea what to do here....todo ASK TROELS....
    }

    @Override
    public void releaseWrite() {
        // This method is implemented by the genius guard. Have absolutely no idea what to do here....todo ASK TROELS....
    }
}
