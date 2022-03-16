/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dslabtrees;

import java.util.Date;

/**
 *
 * @author clatulip
 */
public class ConcertTicket implements Comparable<ConcertTicket> {
    private String name;
    private Date date;
    private double price;

    public ConcertTicket(String name, Date date, double price) {
        this.name = name;
        this.date = date;
        this.price = price;
    }

    public ConcertTicket() {
        name = "";
        date = new Date();
        price = 0.0;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object ct) {
        if (ct == null) return false;
        if (ct == this) return true;
        if (!(ct instanceof ConcertTicket)) return false;
        ConcertTicket c = (ConcertTicket) ct;
        return this.price == c.price;
    }
    
    @Override
    public int compareTo(ConcertTicket ct) {
        //System.out.println("concert ticket compareTo");
        int result = 0;
        // compare by price
        if (this.price < ct.price) {
            result = -1;
        } 
        if (this.price > ct.price) {
            result = 1;
        }
        return result;
    }

    @Override
    public String toString() {
        return "ConcertTicket{" + "name=" + name + ", price=" + price + '}';
    }
    
    
    
    
    
}
