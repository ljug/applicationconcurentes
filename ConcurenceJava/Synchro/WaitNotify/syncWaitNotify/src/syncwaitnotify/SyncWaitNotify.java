/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syncwaitnotify;

/**
 *
 * @author pascal fqres
 */
public class SyncWaitNotify {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Message msg = new Message("Un message de syncronisation");
        Lattente waiter = new Lattente(msg);
        new Thread(waiter,"En Attente").start();
        
        Lattente waiter1 = new Lattente(msg);
        new Thread(waiter1, "Un autre en attente").start();
        
        LeNotifieur notifier = new LeNotifieur(msg);
        new Thread(notifier, "notifieur").start();
        System.out.println("Tous les threads démarrés");

    }
    
}
