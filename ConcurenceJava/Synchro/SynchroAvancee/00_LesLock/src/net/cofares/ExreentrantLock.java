/*
 * La classe ReentrantLock est une implémentation de l'interface Lock qui permet d'utiliser des verrous de manière réentrante.
 * Le verrou est obtenu par un thread si aucun autre thread ne le possède ou si le verrou est déjà détenu par le thread lui-même.
 */
package net.cofares;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author pfares
 */
public class ExreentrantLock {
    private final Lock verrou = new ReentrantLock();
    public void methodeA() throws InterruptedException {
        verrou.lock();
        try {
            System.out.println("MethodeA : " + Thread.currentThread().getName());
            Thread.sleep(2000);
            methodeB();
            Thread.sleep(5000);
        } finally {
            verrou.unlock();
        }

    }

    public void methodeB() {
        verrou.lock();
        try {
            System.out.println("MethodeB : " + Thread.currentThread().getName());
        } finally {
            verrou.unlock();
        }
    }
}
