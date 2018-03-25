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
public class Lattente implements Runnable {
private Message msg;

    public Lattente(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        synchronized (msg) {
            try{
                System.out.println(name + " D " + Util.currentTime());
                msg.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(name + " F " + Util.currentTime());
            //process the message now
            System.out.println(name+" recu: "+msg.getMessage());
        }

         }
    
}
