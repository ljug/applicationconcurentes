package codecommundonneediff;

/**
 * Utilisation de SimpleRunnable exemple même code données différente
 *
 * @author Pascal Fares
 */
public class ccDd {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ThreadGroup tg = new ThreadGroup("ACCOV");
        System.out.printf("Le groupe de Threads %s", tg);
        Runnable tache1 = new SimpleRunnable("Bonjour");
        Runnable tache2 = new SimpleRunnable("un autre bonjour...");
        Thread t1 = new Thread(tg, tache1, "Thread1");
        Thread t2 = new Thread(tg, tache2, "Thread2");
        tg.setDaemon(true);
        t1.start();
        t2.start();
    }
}
