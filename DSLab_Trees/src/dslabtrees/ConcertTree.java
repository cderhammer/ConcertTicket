/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dslabtrees;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import DataStructures.*;
import Exceptions.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author clatulip
 */
public class ConcertTree {

    private LinkedBinarySearchTree<ConcertTicket> concerts;

    public ConcertTree(String concertListingFile) throws FileNotFoundException, IOException, NonComparableElementException {
        concerts = new LinkedBinarySearchTree<ConcertTicket>();
        readConcerts(concertListingFile);
    }

    /**
     * private helper method to read in concert listing file
     *
     * @param theFilename
     * @throws FileNotFoundException
     * @throws IOException
     */
    private void readConcerts(String theFilename) throws FileNotFoundException, IOException, NonComparableElementException {
        //URL url = getClass().getResource(theFilename);
        //File file = new File(url.getPath());
        BufferedReader in = new BufferedReader(new FileReader(theFilename));
        String str;

        while ((str = in.readLine()) != null) {
            String[] tokens = str.split(",");
            if (tokens.length != 3) {
                System.out.println("more or less than three tokens. Tokens.length is:" + tokens.length);
                return;
            }
            ConcertTicket c = new ConcertTicket();
            c.setName(tokens[1]);
            String[] dateTokens = tokens[0].split("/");
            if (dateTokens.length != 3) {
                System.out.println("more or less than three date tokens. dateTokens.length is:" + dateTokens.length);
                return;
            }
            int year = Integer.parseInt(dateTokens[2]);
            int month = Integer.parseInt(dateTokens[0]);
            int day = Integer.parseInt(dateTokens[1]);
            Calendar calendar = new GregorianCalendar(year, month, day);//Integer.getInteger(dateTokens[0]), Integer.getInteger(dateTokens[1]),Integer.getInteger(dateTokens[2]));
            Date concertDate = calendar.getTime();
            c.setDate(concertDate);
            c.setPrice(Double.parseDouble(tokens[2]));

            concerts.addElement(c);
        }

    }

    /**
     * add concert by passing in required info
     *
     * @param bandName String name of band
     * @param ticketPrice double price of ticket
     */
    public void addConcert(String bandName, double ticketPrice) throws NonComparableElementException {
        ConcertTicket c = new ConcertTicket(bandName, new Date(), ticketPrice);
        concerts.addElement(c);

    }

    /**
     * Add concert to tree by passing in ConcertObject
     *
     * @param ct the ConcertObject
     */
    public void addConcert(ConcertTicket ct) throws NonComparableElementException {
        concerts.addElement(ct);
    }

    /**
     * Remove a particular concert from the tree
     *
     * @param price double, match target based on price
     * @return ConcertTicket removed from the tree (or null)
     */
    public ConcertTicket removeConcert(double price) throws NonComparableElementException {

        ConcertTicket t = null;
        ConcertTicket target = new ConcertTicket("name", new Date(), price);
        if (concerts.contains(target)) {
            try {
                t = (ConcertTicket) (concerts.removeElement(target));
            } catch (ElementNotFoundException ex) {
                Logger.getLogger(ConcertTree.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return t;
    }

    /**
     * Find the cheapest ConcertTicket in the tree
     *
     * @return ConcertTicket with cheapest ticket price
     */
    public ConcertTicket getCheapest() {
        try {
            return (ConcertTicket) concerts.findMin();
        } catch (EmptyCollectionException ex) {
            Logger.getLogger(ConcertTree.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Remove the ConcertTicket with the cheapest price
     *
     * @return true if removed
     */
    public boolean removeCheapest() {
        ConcertTicket t = null;
        try {
            t = (ConcertTicket) (concerts.removeMin());
        } catch (EmptyCollectionException ex) {
            Logger.getLogger(ConcertTree.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (t == null) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {

        ArrayList<ConcertTicket> list = concerts.getTreeAsList();
        return list.toString();
    }

}
