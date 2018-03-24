/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deadlock;

/**
 *
 * @author Pascal Fares
 */
public class DeadLock {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // initialisation de 2 récipients liés l'un a l'autre
        final Recipient r1 = new Recipient("R1");
        final Recipient r2 = new Recipient("R2");
        r1.setLautre(r2);
        r2.setLautre(r1);

        // création d'une instance de Runnable qui remplit et vide le recipient1
        // dans le recipient2
        // on peut augmenter le nombre de cycles dans la boucle for
        Runnable tr1 = () -> {
            for (int i = 0; i < 20; i++) {
                System.out.println("Remplir R1");
                r1.remplis();
                System.out.println("Vider R1");
                r1.vide();
            }
        };

        // création d'une instance de Runnable qui remplit et vide le recipient2
        // dans le recipeint1
        // on peut augmenter le nombre de cycles dans la boucle for
        Runnable tr2 = () -> {
            for (int i = 0; i < 20; i++) {
                System.out.println("Remplir R2");
                r2.remplis();
                System.out.println("Vider R2");
                r2.vide();
            }
        };

        // création des threads
        Thread[] r1Apps = new Thread[5];
        Thread[] r2Apps = new Thread[5];

        // creation des threads pour le vidage de la carafe
        // et du verre
        for (int i = 0; i < r1Apps.length; i++) {
            r1Apps[i] = new Thread(tr1, "Recipient R1 Th"+i);
            r2Apps[i] = new Thread(tr2, "Recipient R2 Th"+i);
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
