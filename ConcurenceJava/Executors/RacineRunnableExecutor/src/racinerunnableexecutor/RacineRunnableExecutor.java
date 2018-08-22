/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package racinerunnableexecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author pascalfares
 */
public class RacineRunnableExecutor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 10000; i++) {
            final int k = i;
            service.execute(() -> System.err.println(k+ ": " + Thread.currentThread().getName()));
        }
        service.shutdown();
    }

}
