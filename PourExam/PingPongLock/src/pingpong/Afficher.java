/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pingpong;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pascal Fares
 */
public class Afficher implements Runnable {

    final String moi;
    final ReentrantLock l;
    final Condition maCond;
    final Condition lautreCOnd;

    public Afficher(String m, ReentrantLock l, Condition cmoi, Condition lautre) {
        this.l = l;
        maCond=cmoi;
        lautreCOnd=lautre;
        moi = m;
    }

    @Override
    public void run() {
        while (true) {
            try {
                l.lock();
                if (!l.hasWaiters(lautreCOnd)) {
                    maCond.await();
                }
                System.err.println(moi);
                lautreCOnd.signal();
            } catch (InterruptedException ex) {
                Logger.getLogger(Afficher.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                l.unlock();
            }
        }
    }
}
