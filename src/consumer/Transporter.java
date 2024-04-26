package consumer;

import adapterqueue.Deposit;
import logger.Log;
import treasureroom.Door;
import valuable.Valuable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Transporter implements Runnable {
    private Deposit deposit;
    private Random randomGenerator = new Random();
    private List<Valuable> transportBag;
    private Door treasureRoomDoor;

    public Transporter(Deposit deposit, Door treasureRoomDoor) {
        this.deposit = deposit;
        this.treasureRoomDoor = treasureRoomDoor;
        transportBag = new ArrayList<>();
    }


    @Override
    public void run() {
        while(true) {
            double random = randomGenerator.nextDouble(200-50)+ 50;
            double value =0;
            while (value < random){
                try{
                    Valuable valuable = deposit.get();
                    transportBag.add(valuable);
                    value +=valuable.getValue();
                } catch (Exception e){
                    Log.getInstance().log(e.getMessage());
            }
        }
            try{
                Thread.sleep(5000);
            } catch (InterruptedException e){
                Log.getInstance().log("Taking the values to the safe.. will take 5 seconds");
            }
            treasureRoomDoor.acquireWrite();
            for (Valuable i : transportBag){
                treasureRoomDoor.add(i);
            } treasureRoomDoor.releaseWrite();
              transportBag.clear();
              try{
                  Thread.sleep(3000);
              } catch (InterruptedException e){
                  e.printStackTrace();
              }







    }
}
}
