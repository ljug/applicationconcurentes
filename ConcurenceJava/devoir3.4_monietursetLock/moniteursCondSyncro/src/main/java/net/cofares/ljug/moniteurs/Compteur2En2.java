/*
GNU LESSER GENERAL PUBLIC LICENSE V3.0 
https://www.gnu.org/licenses/lgpl-3.0.fr.html 
 */
package net.cofares.ljug.moniteurs;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pascal Fares <pascal.fares at cofares.net>
 */
public class Compteur2En2 implements Runnable{
    private final int DEBUT;
    private final int FIN;
    private final Lock synchro;
    private final Condition macondition;
    private Compteur2En2 suivant;
    
    public Compteur2En2(int d, int f, Lock fs) {
        DEBUT=d; FIN=f;
        synchro=fs;
        macondition = synchro.newCondition();
    }
    
    @Override
    public void run () {
        synchro.lock();
        System.out.printf("\nDebut du thread %s\n",Thread.currentThread());
        for (int i=DEBUT; i<FIN; i +=2) {
            try {
                getCondition().await();
                System.out.printf("%d ", i);
                suivant.getCondition().signal();
            } catch (InterruptedException ex) {
                Logger.getLogger(Compteur2En2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.printf("\nfin du thread %s\n",Thread.currentThread());
        synchro.unlock();
        
    }

    public void pourStart() {
        synchro.lock();
        try {
            getCondition().signal();
        } finally {
            synchro.unlock();
        }
    }
    /**
     * @return the macondition
     */
    public Condition getCondition() {
        return macondition;
    }

    /**
     * @param suivant the suivant to set
     */
    public void setSuivant(Compteur2En2 suivant) {
        this.suivant = suivant;
    }
}
