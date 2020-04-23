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
        Message msg = new Message("<<Un message de syncronisation>>");
        Lattente waiter;
        waiter = new Lattente(msg);
        new Thread(waiter,"waiter: En Attente").start();
        
        Lattente waiter1 = new Lattente(msg);
        new Thread(waiter1, "waiter1 : un autre en attente").start();
        
        LeNotifieur notifier = new LeNotifieur(msg);
        new Thread(notifier, "notifieur").start();
        System.out.println("main : Tous les threads démarrés");

    }
    
}
