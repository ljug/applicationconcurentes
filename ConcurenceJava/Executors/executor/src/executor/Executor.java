/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author ppfar
 */
public class Executor {

    static class MyRunnable implements Runnable {

        private final long countUntil;

        MyRunnable(long countUntil) {
            this.countUntil = countUntil;
        }

        @Override
        public void run() {
            long sum = 0;
            for (long i = 1; i < countUntil; i++) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor;
        executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (int i = 0; i < 500; i++) {
            Runnable worker = new MyRunnable(10000000L + i);
            executor.execute(worker);
        }
        // This will make the executor accept no new threads
        // and finish all existing threads in the queue
        executor.shutdown();
        // Wait until all threads are finish
        executor.awaitTermination(10,TimeUnit.SECONDS);
        System.out.println("Finished all threads");
    }

}
