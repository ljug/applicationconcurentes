package interupt;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * @author pascalfares
 */
public class InterruptionTempo implements Runnable {

    private final int id;

    public InterruptionTempo(int id) {
        this.id = id;
    }

    public void tempo() {
        try { 
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            //Nous somme interompu pour retransmettre l'arrêt 
            //il faut re-armer l'interruption
            System.out.println("Iterruption du sleep!!!");
            //Thread.currentThread().interrupt();
        }
    }

    @Override
    public void run() {
        int i = 0;
        while (!Thread.interrupted()) {
            System.out.println(i++ + "i° exécution de " + id);
            tempo();
        }
        System.out.println("Fin d'exéc. du code " + id);
        // L'appel à interrupted() a réinitialisé le statut d'interruption 
        System.out.println("code " + id + Thread.currentThread().isInterrupted()); // Affiche: false 
    }

    public static void main(String[] args) throws IOException {
        Thread t1 = new Thread(new InterruptionTempo(1));
        Thread t2 = new Thread(new InterruptionTempo(2));
        t1.start();
        t2.start();
        // Lecture du numéro du processus léger à interrompre 
        //Scanner sc = new Scanner(System.in);
        String rep;
        while (true) {
            //rep=sc.next();
            rep=JOptionPane.showInputDialog("Choisir un nombre 1,2,3 ");
            switch (rep) {
                case "1":
                    t1.interrupt();
                    break;
                case "2":
                    t2.interrupt();
                    break;
                case "3":
                    System.exit(0);
                    break;
            }
        }
    }
}
