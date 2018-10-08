/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pingpong;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Pascal Fares
 */
public class PingPong {

    public static void main(String[] args) throws InterruptedException {
        final ReentrantLock lock = new ReentrantLock();
        final Condition ping = lock.newCondition();
        final Condition pong = lock.newCondition();
        
        new Thread(new Afficher("ping", lock, ping, pong)).start();
        new Thread(new Afficher("pong", lock, pong, ping)).start();     
    }
}
