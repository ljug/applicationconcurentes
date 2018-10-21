/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pourMontrer;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author pfares
 */
public class NewClass  {
 
  private final Lock lock = new ReentrantLock();
 
  public void methodeA() {
    lock.lock();
 
    try {
      System.out.println("MethodeA");
    } finally {
      lock.unlock();
    }
  }
 
  public void methodeB() {
    lock.lock();
    try {
      System.out.println("MethodeB");
    } finally {
      lock.unlock();
    }
  }
}
