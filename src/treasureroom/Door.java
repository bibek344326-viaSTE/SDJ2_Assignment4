package treasureroom;

import valuable.Valuable;

public interface Door {

    void add(Valuable valuable);

    Valuable takeOut() throws Exception;

    void readValuables();

    void acquireRead();
    void acquireWrite();
    void releaseRead();
    void releaseWrite();
}

