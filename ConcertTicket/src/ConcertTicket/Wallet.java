package ConcertTicket;

import java.util.Arrays;

/**
 * This class is a wallet which can store any number of concert tickets.
 *
 * @author stevemacneil
 */
public class Wallet {

    public ConcertTicket[] tickets = new ConcertTicket[10];
    private int size = 0;

    /**
     * Add a concert ticket into the array
     *
     * @param ct a concert ticket being added to the wallet
     */
    public void add(ConcertTicket ct) {
        if (this.size == this.tickets.length) {
            this.resize();
        }
        this.tickets[this.size] = ct;
        this.size++;
    }

    /**
     * Resizes the wallet so that you can fit more tickets.
     *
     */
    public void resize() {
        this.tickets = Arrays.copyOf(this.tickets, 2 * this.tickets.length);
    }

    /**
     * Converts the wallet into a string representation for easy reading.
     *
     * @return a string representation of the wallet
     */
    public String toString() {
        return Arrays.toString(Arrays.copyOf(this.tickets, size));
    }

    /**
     * Returns how many tickets are in the wallet.
     *
     * @return the size of the wallet
     */
    public int getSize() {
        return this.size;
    }

    public ConcertTicket remove() {
        ConcertTicket tick1;
        size = getSize();
        tick1 = tickets[size-1];
        tickets[size-1] = null;
        size--;
        return tick1;
        
        

// DO NOT create an object, only the reference variable.
// Use the size variable to access the last added ConcertTicket
// Point the reference variable to this object.
// Set that array element to null
// Decrement the size variable
// return the ConcertTicket   
    }
}
