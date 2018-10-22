package interupt;

import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * @author pascalfares
 */
public class Interruption implements Runnable {
    private int id;
    public Interruption(int id) {
        this.id = id;
    }
    public void run() {
        int i = 0;
        while (!Thread.interrupted()) {
            System.out.println(i++ + "i° exécution de " + id);
        }
        System.out.println("Fin d'exéc. du code " + id);
        // L'appel à interrupted() a réinitialisé le statut d'interruption 
        System.out.println(Thread.currentThread().isInterrupted()); // Affiche: false 
    }
    public static void main(String[] args) throws IOException {
        Thread t1 = new Thread(new Interruption(1));
        Thread t2 = new Thread(new Interruption(2));
        t1.start();
        t2.start();
        // Lecture du numéro du processus léger à interrompre 
        //Scanner sc = new Scanner(System.in); //Si pas de graphique utiliser Scanner
        String rep;
        while (true) {
            //rep=sc.next();
            rep=JOptionPane.showInputDialog("Choisir un nombre \n 1,2,3 ");
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
