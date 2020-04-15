package cddc;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pascal Fares
 */
public class CDDC {

    /**
     * Test : Code différents Données commune
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Data d = new Data();
            //Création du Runnable
            Tache1 tache1 = new Tache1(d);
            Tache2 tache2 = new Tache2(d);

            //Création des Thread associés
            Thread t1 = new Thread(tache1);
            Thread t2 = new Thread(tache2);
            
            //Lancement des thread
            t1.start();
            t2.start();
            
            //Attente de la fin des threads
            t1.join();
            t2.join();
            
            System.out.printf("\nSe termine avec la valeur globale %d "
                + "devrait être %d!\n", d.getDonnee(), tache1.getDonneePriv() + tache2.getDonneePrivee());
        } catch (InterruptedException ex) {
            Logger.getLogger(CDDC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
