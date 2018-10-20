package cddc;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pascal Fares
 */
public class CDDC {

    /**
     * Code différents Données commune
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Data d = new Data();
            Tache1 tache1 = new Tache1(d);
            Tache2 tache2 = new Tache2(d);

            Thread t1 = new Thread(tache1);
            Thread t2 = new Thread(tache2);
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            System.out.printf("\nSe termine avec la valeur %d devrait être %d!\n", d.getDonnee(), tache1.getDonneePriv()+tache2.getDonneePrivee());
        } catch (InterruptedException ex) {
            Logger.getLogger(CDDC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
