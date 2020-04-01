package lb.edu.isae.threadex;

import java.util.logging.Level;
import java.util.logging.Logger;

class Tache implements Runnable {

    @Override
    public void run() {
       for (int i=0; i< 10; i++) {
           try {
               System.out.println(Thread.currentThread());
               Thread.sleep(100);
           } catch (InterruptedException ex) {
               Logger.getLogger(Tache.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    }
    
}
/**
 *
 * @author Pascal Fares
 */
public class App {
    public static void testSequentiel(Runnable r) {
        var debut= System.currentTimeMillis();
        r.run();
        r.run();
        System.out.println("Temps séquenciel"+(System.currentTimeMillis()-debut));       
    }
    public static void main(String ...args) throws InterruptedException {
        Runnable r = new Tache();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread (r);
        testSequentiel(r);
        long debut;        
        debut= System.currentTimeMillis();
        t1.start();
        t2.start();
        System.out.println("Temps avant les joins "+(System.currentTimeMillis()-debut));
        t1.join();
        t2.join();
        System.out.println("Temps par concurence thread "+(System.currentTimeMillis()-debut));
    }
    
}
