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

    static class MonRunnable implements Runnable {

        private final long counterJusqua;

        MonRunnable(long nombreDeCompte) {
            this.counterJusqua = nombreDeCompte;
        }

        @Override
        public void run() {
            long sum = 0;
            for (long i = 1; i <= counterJusqua; i++) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    /**
     * @param args Paramètre de la ligne de commande
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor;
        executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (int i = 0; i < 500; i++) {
            Runnable worker = new MonRunnable(10000000L + i);
            executor.execute(worker);
        }
        // L'executor n'accptera plus de nouveau Thread
        // et terminera les Thread courant
        executor.shutdown();
        // Attendre la fin de tous les Thread penndant maximum 10 secondes
        executor.awaitTermination(10,TimeUnit.SECONDS);
        System.out.println("Tous les Thread sont terminés");
    }

}
