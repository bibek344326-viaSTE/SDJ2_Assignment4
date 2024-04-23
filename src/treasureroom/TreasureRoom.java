package treasureroom;
import logger.Log;
import valuable.Valuable;
import valuable.Ruby;
import valuable.Jewel;
import valuable.Diamond;
import valuable.GoldNugget;
import valuable.WoodenCoin;

import java.util.ArrayList;

public class TreasureRoom {
    private ArrayList<Valuable> valuables;
    private Log logger;

    public TreasureRoom(){
        this.valuables = new ArrayList<>();
        this.logger = Log.getInstance();
    }
    public void add(Valuable valuable) {valuables.add(valuable);}

    public Valuable takeOut() throws Exception {
        if (valuables.isEmpty()) {
            throw new Exception("Safe is empty");
        }
        return valuables.remove(0);
    }
}
