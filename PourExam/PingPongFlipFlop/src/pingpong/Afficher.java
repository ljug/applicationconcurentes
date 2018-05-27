/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pingpong;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pascal Fares
 */
public class Afficher implements Runnable {
    final String moi;
    private Afficher lautre;
    public Afficher(String m) {
         moi=m;
        this.lautre=null;
    }
    public Afficher(String m, Afficher lautre){
        moi=m;
        this.lautre=lautre;
    }
    @Override
    public void run() {
        while (true) {
            try {
                synchronized(this) {
                    this.wait();
                }
                System.out.println(moi);
                synchronized(lautre) {
                    lautre.notifyAll();
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Afficher.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } 

    /**
     * @param lautre the lautre to set
     */
    public void setLautre(Afficher lautre) {
        this.lautre = lautre;
    }
}
