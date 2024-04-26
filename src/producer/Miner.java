package producer;

import adapterqueue.Deposit;
import valuable.Mine;
import valuable.Valuable;

public class Miner implements Runnable {
    private Deposit deposit;

    public Miner(Deposit deposit) {
        this.deposit = deposit;
    }


    @Override
    public void run() {
        while (true) {
            Valuable valuable = Mine.getValuable();
            deposit.add(valuable);
            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
