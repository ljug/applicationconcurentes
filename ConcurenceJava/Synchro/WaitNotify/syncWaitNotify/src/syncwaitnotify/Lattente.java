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

    private final Message msg;

    public Lattente(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        synchronized (msg) {
            try {
                System.out.println(name + " D " + Util.currentTime());
                msg.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Lattente.class.getName()).log(Level.WARNING, null, ex);
            }
            System.out.println(name + " F " + Util.currentTime());
            //process the message now
            System.out.println(name + " recu: " + msg.getMessage());
        }

    }

}
