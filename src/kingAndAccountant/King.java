package kingAndAccountant;

import logger.Log;
import treasureroom.Door;
import valuable.Valuable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class King implements Runnable{

    private Random random;
    private Door treasureRoomDoor;
    private boolean kingParty;

    public King(Door treasureRoomDoor) {
        this.random=new Random();
        this.treasureRoomDoor=treasureRoomDoor;
    }
    @Override
    public void run() {
        while(true){
            double randomInt=random.nextDouble(150-50) + 50;
            double value = 0;
            treasureRoomDoor.acquireWrite();
            List<Valuable> temp = new ArrayList<>();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            kingLoopingThroughAllAvailableValues:
            while (true) {
                try {
                    Valuable valuable = treasureRoomDoor.takeOut();
                    value += valuable.getValue();
                    if (value >= randomInt) {
                        kingParty = true;
                        break kingLoopingThroughAllAvailableValues;
                    }
                    temp.add(valuable);   // if the value is not met, the king stores the valuable in a local list...
                } catch (Exception e) {

                    for (Valuable i : temp
                    ) {
                        treasureRoomDoor.add(i);
                    }
                    break kingLoopingThroughAllAvailableValues;

                }
            }
            treasureRoomDoor.releaseWrite();
            if (kingParty) {
                Log.getInstance().log("\t\t\t\t\t\t----PARTY IS HERE---THE KING IS HAPPY--- --");
            } else {
                Log.getInstance().log("\t\t\t\t\t\t-----NOT ENOUGH RESOURCES--POOR KING");
            }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        }
    }

