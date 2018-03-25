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
public class LeNotifieur implements Runnable {

    private Message msg;

    public LeNotifieur(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " demarré");
        try {
            Thread.sleep(1000);
            synchronized (msg) {
                msg.setMessage(name + " transmission d'une notification effectué");
                //msg.notify();
                msg.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
