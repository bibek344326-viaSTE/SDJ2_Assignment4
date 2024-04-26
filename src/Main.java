import adapterqueue.Deposit;
import consumer.Transporter;
import kingAndAccountant.Accountant;
import kingAndAccountant.King;
import producer.Miner;
import treasureroom.Door;
import treasureroom.GuardsMan;
import valuable.Mine;

public class Main {
    public static void main(String[] args) {
        Deposit deposit = new Deposit();
        Mine mine = new Mine();
        Door treasureRoomDoor = new GuardsMan();
        King theKing = new King(treasureRoomDoor);
        Accountant accountant = new Accountant(treasureRoomDoor);

        for (int i = 0; i < 3; i++) {                                // Three miners
            new Thread(new Miner(deposit,mine)).start();
        }
        for (int i = 0; i < 1; i++) {
            new Thread(new Transporter(deposit,treasureRoomDoor)).start();
        }

        new Thread(theKing).start();
        new Thread(accountant).start();
    }
}
