/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dslabtrees;

import Exceptions.NonComparableElementException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author clatulip
 */
public class DSLab_Trees {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, NonComparableElementException {
        // create the tree using the concert listing csv file
        ConcertTree concertTree = new ConcertTree("concert.csv");
        
        // what does the tree look like, printed out
        // using a level-order traversal?
        System.out.println(concertTree.toString());

        // TODO:  Remove and re-add elements until the tree is balanced.
        
    }
    
}
