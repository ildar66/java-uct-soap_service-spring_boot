package ru.masterdm.uct.entity;

/**
 * Client entity class.
 * @author Ildar Shafigullin
 */
public class Client {

    private int custID;

    /**
     * Returns client id.
     * @return client id
     */
    public int getCustID() {
        return custID;
    }

    /**
     * Sets client id.
     * @param custID client id
     */
    public void setCustID(int custID) {
        this.custID = custID;
    }

    @Override
    public String toString() {
        return "Client{" +
               "custID=" + custID +
               '}';
    }
}
