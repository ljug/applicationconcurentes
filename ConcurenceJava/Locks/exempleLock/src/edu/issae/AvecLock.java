/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.issae;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author ppfar
 */
public class AvecLock {
    Integer i;
    private final Lock lock = new ReentrantLock();
    public AvecLock(Integer i) {
        this.i=i;
    }
    public void inc () {
        lock.lock();
        i = i +1;
        autre();
       
    }
    public void autre() {
        i = i-1;
         lock.unlock();
    }
    public int getValue(){
        return i;
    }
}
