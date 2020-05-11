/*
GNU LESSER GENERAL PUBLIC LICENSE V3.0 
https://www.gnu.org/licenses/lgpl-3.0.fr.html 
 */
package net.cofares.ljug.moniteurs;

import java.io.IOException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Pascal Fares <pascal.fares at cofares.net>
 */
public class Exemple {
    public static void main(String ...args) throws IOException {
        Lock l = new ReentrantLock();

        Compteur2En2 paire = new Compteur2En2(0, 100, l);
        Compteur2En2 impaire = new Compteur2En2(1, 100, l);
     
        paire.setSuivant(impaire);
        impaire.setSuivant(paire);
        
        Thread t1=new Thread(paire, "paire");
        Thread t2=new Thread(impaire, "impaire");
        
        t1.start();
        t2.start();
        System.out.println("enter to start :");
        System.in.read();
        paire.pourStart();
    }
}
