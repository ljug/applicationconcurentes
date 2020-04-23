package codecommundonneediff;

/**
 * Utilisation de SimpleRunnable exemple même code données différente
 * @author Pascal Fares
 */
public class ccDd {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {

        Runnable tache1 = new SimpleRunnable("Bonjour");
        Runnable tache2 = new SimpleRunnable("un autre bonjour...");  
        
        Thread t1 = new Thread(tache1, "Thread1");
        Thread t2 = new Thread(tache2, "Thread2");
        
        t1.setDaemon(true);
        t2.setDaemon(true);
        t1.start();
        t2.start();  
        Thread.sleep(200);
    }  
}
