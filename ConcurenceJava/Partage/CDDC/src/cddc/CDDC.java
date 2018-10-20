/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cddc;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pascal Fares
 */
public class CDDC {

    /**
     * Code différents Données commune
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Data d = new Data();
            Runnable tache1 = new Tache1(d);
            Runnable tache2 = new Tache2(d);

            Thread t1 = new Thread(tache1);
            Thread t2 = new Thread(tache2);
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            System.out.printf("\nSe termine avec la valeur %d devrait être 200000!\n", d.getDonnee());
        } catch (InterruptedException ex) {
            Logger.getLogger(CDDC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
