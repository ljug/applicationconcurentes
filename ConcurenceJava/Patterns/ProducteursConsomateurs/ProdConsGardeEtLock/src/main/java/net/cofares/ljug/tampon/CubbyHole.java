/*
 * Copyright © <copyright holders>
 * ISSAE - Cnam Liban
 * Pascal Fares
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the “Software”), 
 * to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions: 
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 * The Software is provided “as is”, without warranty of any kind, express or implied, including but not limited to the warranties of merchantability, 
 * fitness for a particular purpose and noninfringement. In no event shall the authors or copyright holders be liable for any claim, damages or other liability, 
 * whether in an action of contract, tort or otherwise, arising from, out of or in connection with the software or the use or other dealings in the Software. »
 */
package net.cofares.ljug.tampon;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.cofares.ljug.prodcons.Consomateur;
import net.cofares.ljug.prodcons.Producteur;

/**
 *
 * @author pascalfares
 */
public class CubbyHole {

    /**
     * Le contenu : pour simplifier un int!
     */
    private int contents;
    boolean donneExiste = false;
    /**
     * Donnée disponible dans le cube?
     */
    private final Lock lock = new ReentrantLock();
    private final Condition vide = lock.newCondition();
    private final Condition plein = lock.newCondition();

    public int get() {
        // when non vide => On va lire la seule donnée disponible donc 
        // le tampon sera vide
        try {
            lock.lock();
            //System.out.println("get "+ donneExiste + " "+  contents);
            while (!donneExiste) vide.await();
            donneExiste = false;
            plein.signalAll();
        } catch (InterruptedException ex) {
            Logger.getLogger(CubbyHole.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            lock.unlock();
        }
        return contents;
    }

    public void put(int value) {
       // when non vide => On va lire la seule donnée disponible donc 
        // le tampon sera vide
        try {
            lock.lock();
            //System.out.println("put"+ donneExiste + " "+  value);
            while (donneExiste) plein.await();
            contents = value;
            donneExiste=true;
            vide.signalAll();
        } catch (InterruptedException ex) {
            Logger.getLogger(CubbyHole.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            lock.unlock();
        }

    }

    /**
     * Pour le test
     *
     * @param args
     */
    public static void main(String[] args) {
        CubbyHole c = new CubbyHole();
        Producteur p1 = new Producteur(c, 1);
        Consomateur c1 = new Consomateur(c, 1);
        Consomateur c2 = new Consomateur(c, 2);
        p1.start();
        c1.start();
        c2.start();
    }
}
