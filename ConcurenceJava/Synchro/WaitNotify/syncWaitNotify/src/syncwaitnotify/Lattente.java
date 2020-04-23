/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syncwaitnotify;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pascal fqres
 */
public class Lattente implements Runnable {

    private Message msg;

    public Lattente(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        synchronized (msg) {
            System.out.println(Thread.currentThread() + " : D : " + Util.currentTime());
            try {
                msg.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Lattente.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(Thread.currentThread() + " :  F : " + Util.currentTime());
            //process the message now
            System.out.println(Thread.currentThread() + " recu: " + msg.getMessage());
        }

    }

}
