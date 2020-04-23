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
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup tg = new ThreadGroup("ACCOV");
        System.out.printf("Le groupe de Threads %s\n", tg);
        tg.setDaemon(true);
        tg.setMaxPriority(7);
        Runnable tache1 = new SimpleRunnable("Bonjour");
        Runnable tache2 = new SimpleRunnable("un autre bonjour...");
        Thread t1 = new Thread(tg, tache1, "Thread1");
        Thread t2 = new Thread(tg, tache2, "Thread2");
        tg.setDaemon(true);
        System.out.printf("%s %s\n",t1.getThreadGroup(), t2.getThreadGroup());
        System.out.println("Sont-il demon? "+ t1.isDaemon());
        t1.start();
        t2.start();
        Thread.sleep(10);
        System.exit(0);
        
    }
}
