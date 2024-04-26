package kingAndAccountant;

import treasureroom.Door;

public class Accountant implements Runnable{

    private Door treasureRoomDoor;

    public Accountant(Door treasureRoomDoor){
        this.treasureRoomDoor = treasureRoomDoor;
    }
    @Override
    public void run() {
        while (true) {

            treasureRoomDoor.acquireRead();
            treasureRoomDoor.countValuables();
            treasureRoomDoor.releaseRead();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    }
