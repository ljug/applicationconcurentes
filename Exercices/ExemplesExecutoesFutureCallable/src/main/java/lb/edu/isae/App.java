package lb.edu.isae;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static lb.edu.isae.Exemple1.testExecutorAndFutureCallable;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        if (args.length == 0) {
            try {
                Exemple.testExecutorAndFutureCallable();
            } catch (InterruptedException | ExecutionException ex) {
                Logger.getLogger(App.class.getName()).log(Level.INFO, null, ex);
            }
        } else {
            try {
                int cores = Runtime.getRuntime().availableProcessors();               
                testExecutorAndFutureCallable(1);
                testExecutorAndFutureCallable(cores);
                testExecutorAndFutureCallable(2*cores);
            } catch (InterruptedException | ExecutionException ex) {
                Logger.getLogger(App.class.getName()).log(Level.INFO, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
