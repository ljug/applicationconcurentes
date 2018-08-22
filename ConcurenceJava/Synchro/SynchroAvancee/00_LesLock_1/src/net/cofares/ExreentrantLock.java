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
