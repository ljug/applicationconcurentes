package deadlock;

/**
 * @author Pascal Fares
 */
public class DeadLock {

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        // initialisation de 2 récipients liés l'un a l'autre
        final Recipient r1 = new Recipient("R1");
        final Recipient r2 = new Recipient("R2");
        r1.setLautre(r2);
        r2.setLautre(r1);

        // création d'une instance de Runnable (représentant un travailleur) 
        // qui remplit et vide le recipient1 de et vers le recipient2
        Runnable tr1 = () -> {
            // on peut augmenter le nombre de cycles dans la boucle for
            for (int i = 0; i < 20; i++) {
                System.out.println(Thread.currentThread()+ "veut Remplir R1");
                r1.remplis();
                System.out.println(Thread.currentThread()+  "veut vider R1");
                r1.vide();
            }
        };

        // création d'une instance de Runnable (représentant un travailleur) 
        // qui remplit et vide le recipient2 de et vers le recipient1
        Runnable tr2 = () -> {
            for (int i = 0; i < 20; i++) {
                System.out.println(Thread.currentThread()+ "veut Remplir R2");
                r2.remplis();
                System.out.println(Thread.currentThread()+  "veut vider R2");
                r2.vide();
            }
        };

        // création des threads (5 travailleur de chaque type (R1->R2) ou (R2->R1)
        Thread[] r1Apps = new Thread[5];
        Thread[] r2Apps = new Thread[5];

        // creation des threads pour le vidage de la carafe
        // et du verre
        for (int i = 0; i < r1Apps.length; i++) {
            r1Apps[i] = new Thread(tr1, "Recipient1 T" + i);
            r2Apps[i] = new Thread(tr2, "Recipient2 T" + i);
        }

        // lancement des threads
        System.out.println("Lancement ");
        for (int i = 0; i < r1Apps.length; i++) {
            r1Apps[i].start();
            r2Apps[i].start();
        }

        // attente de la fin de l'exécution des threads
        for (int i = 0; i < r1Apps.length; i++) {
            r1Apps[i].join();
            r2Apps[i].join();
        }
        System.out.println("Fin ");
    }

}
