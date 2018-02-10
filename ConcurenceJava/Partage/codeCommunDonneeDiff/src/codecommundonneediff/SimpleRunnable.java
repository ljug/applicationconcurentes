package codecommundonneediff;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Simple Runnable avec données privée
 * @author Pascal Fares
 */
public class SimpleRunnable implements Runnable {

    private final String message;

    public SimpleRunnable(String m) {
        message = m;
    }
    @Override
    public void run() {
        for (;;) {
            try {
                System.out.printf("%s %s\n", Thread.currentThread(), message);
                sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(SimpleRunnable.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
