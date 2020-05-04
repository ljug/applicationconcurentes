/*
GNU LESSER GENERAL PUBLIC LICENSE V3.0 
https://www.gnu.org/licenses/lgpl-3.0.fr.html 
 */
package net.cofares.ljug.garde;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * La classe Garde un moniteur sur un propriété
 * garde() : when(propriete)
 * notgarde() : when(not proprieteé)
 * @author Pascal Fares <pascal.fares at cofares.net>
 */
public class Garde {
    //TODO pourrait être un prédicat 
    private boolean garde;

    public Garde(boolean g) {
        //On initialise la garde
        garde = g;
    }
    public synchronized boolean isGarde() {
        return garde;
    }

    public synchronized  void garde() {
        while (!isGarde()) try {
            wait();
        } catch (InterruptedException ex) {
            Logger.getLogger(Garde.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    public synchronized void notGarde() {
        while (isGarde()) try {
            wait();
        } catch (InterruptedException ex) {
            Logger.getLogger(Garde.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param garde the garde to set
     */
    public synchronized void setGarde(boolean garde) {
        //vérifier si la valeur de la garde a changé
        //Si oui faire notifyAll
        if (this.garde != garde) {
            this.garde = garde;
            notifyAll();
            
        }
        
    }

}
