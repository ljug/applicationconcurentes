/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pingpong;

/**
 *
 * @author Pascal Fares
 */
public class PingPong {
    public static void main(String[] args) throws InterruptedException {
        Afficher ping = new Afficher("ping");
        Afficher pong = new Afficher("pong",ping);
        ping.setLautre(pong);
        Thread tping = new Thread(ping);
        tping.start();
        Thread tpong = new Thread(pong);
        tpong.start();
        //attendre un peu puis lancer ping pour commencer
        Thread.sleep(1000);
        synchronized(ping){
            ping.notifyAll();
        }
    }   
}
