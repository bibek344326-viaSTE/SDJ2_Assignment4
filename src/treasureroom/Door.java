package treasureroom;

import valuable.Valuable;

public interface Door {

    void add(Valuable valuable);

    Valuable takeOut() throws Exception;

    void countValuables();

    void acquireRead();
    void acquireWrite();
    void releaseRead();
    void releaseWrite();
}


