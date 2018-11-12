/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cofares;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pfares
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final ExreentrantLock sut = new ExreentrantLock();

        Thread[] threads = new Thread[2];

        threads[0] = new Thread(() -> {
            try {
                System.out.println("Debut thread 0");
                sut.methodeA();
                System.out.println("fin thread 0");
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }, " Thread 0");

        threads[1] = new Thread(() -> {
            System.out.println("Debut thread 1");
            sut.methodeB();
            System.out.println("Fin thread 1");
        }, " Thread 1");

        threads[0].start();
        threads[1].start();
    }

}
