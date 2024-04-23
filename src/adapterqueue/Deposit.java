package adapterqueue;

import logger.Log;
import valuable.Valuable;

import java.util.ArrayList;
import java.util.List;

public class Deposit {
    private List<Valuable> list;
    private Log logger;

    public Deposit() {
        list = new ArrayList<>();
        logger = Log.getInstance();
    }

    public void add(Valuable valuable) {
        list.add(valuable);
        logger.log(valuable.toString());
    }

    public Valuable get() throws Exception {
        if (list.isEmpty()) throw new Exception("List is empty");
        Valuable valuable = list.get(0);
        logger.log(valuable.toString());
        return valuable;
    }

    public Valuable remove() {
        Valuable valuable = list.remove(0);
        logger.log(valuable.getName() + " removed from the deposit");
        return valuable;
    }

    public int size() {
        return list.size();
    }

}
