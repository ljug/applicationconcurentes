/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callableexemple;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *
 * @author pascalfares
 */
public class CallableExemple {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<String> callThread = new Callable<String>() {

            public String call() throws Exception {
                try {
                    // on simule de façon simple un calcul
                    // qui prend du temps
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    // rien
                }
                // et l'on retourne le nom du thread
                // dans lequel on se trouve
                return Thread.currentThread().getName();
            }
        };
        FutureTask<String> future = new FutureTask<>(callThread);

        // un future est une instance de Runnable, on peut 
        // donc le lancer de cette façon
        new Thread(future).start();

        // on affiche le nom du thread dans lequel on se trouve
        System.out.println(Thread.currentThread().getName());

        // jette ExecutionException
        // puis le résultat de l'exécution de notre tâche
        System.out.println(future.get());
    }
}
