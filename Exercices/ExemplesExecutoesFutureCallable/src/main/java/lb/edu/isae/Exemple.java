/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lb.edu.isae;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author ppfar
 */
public class Exemple {
    public static void testExecutorAndFutureCallable() throws InterruptedException, ExecutionException {
        ExecutorService es = Executors.newSingleThreadExecutor();
        long debut = System.currentTimeMillis();
        System.out.println("Soumission du callable pour le calcul de factorielle 10");
        Future<Long> result10 = es.submit(new CalculFactorielle(10));
        System.out.printf("Temps pour lancer la factorielle : %d%n", System.currentTimeMillis() - debut);      
        debut = System.currentTimeMillis();
        long factorialof10 = result10.get();
        System.out.printf("%d factorial of 10 is : %d%n", System.currentTimeMillis() - debut,factorialof10);
        debut = System.currentTimeMillis();
        es.shutdown();
        System.out.printf("Fin du test,  %d %n%n", System.currentTimeMillis() - debut);
    }
}
