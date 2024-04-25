package treasureroom;


import valuable.Valuable;

public class GuardsMan implements Door {

    private Door door;

    private boolean activeWriter;
    private int activeReaders;

    public GuardsMan() {
        this.door = new TreasureRoom();
    }

    @Override
    public void add(Valuable valuable) {

        door.add(valuable);

    }

    @Override
    public Valuable takeOut() throws Exception {
//        acquireWrite();
        return door.takeOut();

    }

    @Override
    public void countValuables() {
//        acquireRead();
        door.countValuables();
//        releaseRead();
    }

    public synchronized void acquireRead() {
        while (activeWriter) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        activeReaders++;
    }

    public synchronized void acquireWrite() {
        while (activeWriter || activeReaders > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        activeWriter = true;
    }

    public synchronized void releaseRead() {
        activeReaders--;
        notifyAll();

    }

    public synchronized void releaseWrite() {
        activeWriter = false;
        notifyAll();

    }

}
